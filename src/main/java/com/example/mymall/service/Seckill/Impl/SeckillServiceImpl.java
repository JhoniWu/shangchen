package com.example.mymall.service.Seckill.Impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.mymall.dto.SeckillOrder;
import com.example.mymall.dto.portal.SeckillSessionWithSkusVo;
import com.example.mymall.dto.portal.SeckillSkuRedisTo;
import com.example.mymall.dto.portal.SkuInfoVo;
import com.example.mymall.mbg.mapper.PmsSkuStockMapper;
import com.example.mymall.mbg.model.PmsSkuStock;
import com.example.mymall.mbg.model.SmsSeckillSession;
import com.example.mymall.mbg.model.UmsMember;
import com.example.mymall.service.Seckill.SeckillService;
import com.example.mymall.service.Sms.SeckillSessionService;
import com.example.mymall.service.Ums.UmsMemberService;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-07-08 16:53
 **/
@Service
public class SeckillServiceImpl implements SeckillService {
	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private SeckillSessionService seckillSessionService;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private RedissonClient redissonClient;
	@Autowired
	private PmsSkuStockMapper skuStockMapper;
	@Autowired
	private UmsMemberService memberService;

	private final String SESSION__CACHE_PREFIX = "seckill:sessions:";
	private final String SECKILL_CHARE_PREFIX = "seckill:skus";
	private final String SKU_STOCK_SEMAPHORE = "seckill:stock:";

	/**
	 * 上架三天需要秒杀的商品
	 */
	@Override
	public void uploadSeckillSkuLatest3Days() {

		List<SmsSeckillSession> lates3DaySession = seckillSessionService.getLates3DaySession();
		List<SeckillSessionWithSkusVo> sessionData = new ArrayList<>();
		BeanUtils.copyProperties(lates3DaySession, sessionData);
		//缓存到Redis
		//1、缓存活动信息
		saveSessionInfos(sessionData);

		//2、缓存活动的关联商品信息
		saveSessionSkuInfo(sessionData);
	}

	/**
	 * 缓存秒杀活动所关联的商品信息
	 *
	 * @param sessionData
	 */
	private void saveSessionSkuInfo(List<SeckillSessionWithSkusVo> sessionData) {
		sessionData.stream().forEach(session -> {
			BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(SECKILL_CHARE_PREFIX);
			session.getRelationSkus().stream().forEach(seckillSkuVo -> {
				//生成随机码
				String token = UUID.randomUUID().toString().replace("_", "");
				String redisKey = seckillSkuVo.getPromotionSessionId().toString() + "-" + seckillSkuVo.getSkuId().toString();
				if (!operations.hasKey(redisKey)) {
					//缓存商品信息
					SeckillSkuRedisTo redisTo = new SeckillSkuRedisTo();
					Long skuId = seckillSkuVo.getSkuId();
					//查询sku基本信息
					PmsSkuStock skuStock = skuStockMapper.selectByPrimaryKey(skuId);
					SkuInfoVo skuInfoVo = new SkuInfoVo();
					BeanUtils.copyProperties(skuStock, skuInfoVo);
					redisTo.setSkuInfo(skuInfoVo);

					//sku秒杀信息
					BeanUtils.copyProperties(seckillSkuVo, redisTo);

					//设置当前商品秒杀时间信息
					redisTo.setStartTime(session.getStartTime().getTime());
					redisTo.setEndTime(session.getEndTime().getTime());

					//设置商品的随机码（防止恶意攻击）
					redisTo.setRandomCode(token);

					//序列化json格式存入redis中
					String seckillValue = JSON.toJSONString(redisTo);
					operations.put(seckillSkuVo.getPromotionSessionId().toString() + "-" + seckillSkuVo.getSkuId().toString(), seckillValue);

					//如果当前这个场次的商品库存信息已经上架就不需要上架
					//5、使用库存作为分布式Redisson信号量（限流）
					// 使用库存作为分布式信号量
					RSemaphore semaphore = redissonClient.getSemaphore(SKU_STOCK_SEMAPHORE + token);
					//商品可以秒杀的数量作为信号量
					semaphore.trySetPermits(seckillSkuVo.getSeckillCount());

				}
			});
		});
	}

	/**
	 * 缓存秒杀活动信息
	 *
	 * @param sessionData
	 */
	private void saveSessionInfos(List<SeckillSessionWithSkusVo> sessionData) {
		sessionData.stream().forEach(session -> {
			//获取当前活动开始和结束的时间戳
			Long startTime = session.getStartTime().getTime();
			Long endTime = session.getEndTime().getTime();

			//存入到redis中的key
			String key = SESSION__CACHE_PREFIX + startTime + "_" + endTime;

			//判断Redis中是否已经存在该信息
			Boolean hasKey = redisTemplate.hasKey(key);
			if (!hasKey) {
				//获取活动中所有商品的skuId
				List<String> skuIds = session.getRelationSkus().stream()
					.map(item -> item.getPromotionSessionId() + "-" +
						item.getSkuId().toString())
					.collect(Collectors.toList());
				;
				redisTemplate.opsForList().leftPushAll(key, skuIds);
			}
		});
	}

	@Override
	public List<SeckillSkuRedisTo> getCurrentSeckillSkus() {
		Long currentTime = System.currentTimeMillis();

		//从redis中查询所有以seckill：sessions开头的数据
		Set<String> keys = redisTemplate.keys(SESSION__CACHE_PREFIX + "*");
		for (String key : keys) {
			//
			String replace = key.replace(SESSION__CACHE_PREFIX, "");
			String[] s = replace.split("_");
			//获取存入redis商品的开始时间
			Long startT = Long.parseLong(s[0]);
			Long endT = Long.parseLong(s[1]);

			//判断是否是当前秒杀场次
			if (currentTime >= startT && currentTime <= endT) {
				//获取这个秒杀场次所需要的所有商品信息
				List<String> range = redisTemplate.opsForList().range(key, -100, 100);
				BoundHashOperations<String, String, String> hasOps = redisTemplate.boundHashOps(SECKILL_CHARE_PREFIX);
				assert range != null;
				List<String> listValue = hasOps.multiGet(range);
				if (listValue != null && listValue.size() >= 0) {
					List<SeckillSkuRedisTo> collect = listValue.stream().map(item -> {
						String items = (String) item;
						SeckillSkuRedisTo redis = JSON.parseObject(items, SeckillSkuRedisTo.class);
						//当前秒杀开始需要随机码
						return redis;
					}).collect(Collectors.toList());
					break;
				}

			}
		}
		return null;
	}


	/**
	 * 根据skuId查询商品是否参加秒杀活动
	 *
	 * @param skuId
	 * @return
	 */
	@Override
	public SeckillSkuRedisTo getSkuSeckillInfo(Long skuId) {
		//1、找到所有需要秒杀的商品的key信息---seckill:skus
		BoundHashOperations<String, String, String> hashOps = redisTemplate.boundHashOps(SECKILL_CHARE_PREFIX);

		//拿到所有的key
		Set<String> keys = hashOps.keys();
		if (keys != null && keys.size() > 0) {
			//4-45
			String reg = "\\d-" + skuId;
			for (String key : keys) {
				//如果匹配上了
				if (Pattern.matches(reg, key)) {
					//从redis中取出数据来
					String redisValue = hashOps.get(key);
					//序列化
					SeckillSkuRedisTo redisTo = JSON.parseObject(redisValue, SeckillSkuRedisTo.class);

					//随机码
					Long currentTime = System.currentTimeMillis();
					Long startTime = redisTo.getStartTime();
					Long endTime = redisTo.getEndTime();
					//如果当前时间大于等于秒杀活动开始时间并且要小于活动结束时间
					if (currentTime >= startTime && currentTime <= endTime) {
						return redisTo;
					}
					redisTo.setRandomCode(null);
					return redisTo;
				}
			}
		}
		return null;
	}

	/**
	 * 当前商品进行秒杀（秒杀开始）
	 *
	 * @param killId
	 * @param key
	 * @param num
	 * @return
	 */
	@Override
	public String kill(String killId, String key, Integer num) throws InterruptedException {
		Long s1 = System.currentTimeMillis();

		//获取当前用户信息
		UmsMember member = memberService.getCurrentMember();

		//获取当前秒杀商品的详情信息
		BoundHashOperations<String, String, String> hashOps = redisTemplate.boundHashOps(SECKILL_CHARE_PREFIX);
		String skuInfoValue = hashOps.get(killId);
		if (StringUtils.isEmpty(skuInfoValue)) {
			return null;
		}
		//(合法性效验)
		SeckillSkuRedisTo redisTo = JSON.parseObject(skuInfoValue, SeckillSkuRedisTo.class);
		Long startTime = redisTo.getStartTime();
		Long endTime = redisTo.getEndTime();
		long currentTime = System.currentTimeMillis();
		//判断当前这个秒杀请求是否在活动时间区间内(效验时间的合法性)
		if (currentTime >= startTime && currentTime <= endTime) {
			//2、效验随机码和商品id
			String randomCode = redisTo.getRandomCode();
			String skuId = redisTo.getPromotionSessionId() + "-" + redisTo.getSkuId();
			if (randomCode.equals(key) && killId.equals(skuId)) {
				//3、验证购物数量是否合理和库存量是否充足
				Integer seckillLimit = redisTo.getSeckillLimit();
				//获取信号量
				String seckillCount = redisTemplate.opsForValue().get(SKU_STOCK_SEMAPHORE + randomCode);
				Integer count = Integer.valueOf(seckillCount);
				//判断信号量是否大于0,并且买的数量不能超过库存
				if (count > 0 && num <= seckillLimit && count > num) {
					//4、验证这个人是否已经买过了（幂等性处理）,如果秒杀成功，就去占位。userId-sessionId-skuId
					//SETNX 原子性处理
					String redisKey = member.getId() + "-" + skuId;
					//设置自动过期(活动结束时间-当前时间)
					Long ttl = endTime - currentTime;
					Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(redisKey, num.toString(), ttl, TimeUnit.MILLISECONDS);
					if (aBoolean) {
						//占位成功说明从来没有买过,分布式锁(获取信号量-1)
						RSemaphore semaphore = redissonClient.getSemaphore(SKU_STOCK_SEMAPHORE + randomCode);
						//TODO 秒杀成功，快速下单
						boolean semaphoreCount = semaphore.tryAcquire(num, 100, TimeUnit.MILLISECONDS);
						//保证Redis中还有商品库存
						//保证Redis中还有商品库存
						if (semaphoreCount) {
							//创建订单号和订单信息发送给MQ
							// 秒杀成功 快速下单 发送消息到 MQ 整个操作时间在 10ms 左右
							String timeId = IdWorker.getTimeId();
							SeckillOrder order = new SeckillOrder();
							order.setOrderSn(timeId);
							order.setMemberId(member.getId());
							order.setNum(num);
							order.setPromotionSessionId(redisTo.getPromotionSessionId());
							order.setSkuId(redisTo.getSkuId());
							order.setSeckillPrice(redisTo.getSeckillPrice());
							rabbitTemplate.convertAndSend("order-event-exhcange", "order.seckill.order", order);
							long s2 = System.currentTimeMillis();
							return timeId;
						}
					}
				}
			}
		}
		return null;
	}
}