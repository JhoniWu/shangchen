package com.example.mymall.service.Sms.Impl;

import com.example.mymall.mbg.mapper.SmsSeckillSessionMapper;
import com.example.mymall.mbg.model.SmsSeckillSession;
import com.example.mymall.mbg.model.SmsSeckillSessionExample;
import com.example.mymall.mbg.model.SmsSeckillSkuRelation;
import com.example.mymall.service.Sms.SeckillSessionService;
import com.example.mymall.service.Sms.SeckillSkuRelationService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: MyMall
 * @description: 秒杀活动场次
 * @author: Max Wu
 * @create: 2023-07-08 13:17
 **/
@Service
public class SeckillSessionServiceImpl implements SeckillSessionService {
	@Autowired
	private SmsSeckillSessionMapper seckillSessionMapper;
	@Autowired
	private SeckillSkuRelationService seckillSkuRelationService;

	@Override
	public int add(SmsSeckillSession seckillSession) {
		return seckillSessionMapper.insert(seckillSession);
	}

	@Override
	public int delete(List<Long> ids) {
		SmsSeckillSessionExample example = new SmsSeckillSessionExample();
		example.createCriteria().andIdIn(ids);
		return seckillSessionMapper.deleteByExample(example);
	}

	@Override
	public int update(Long id, SmsSeckillSession seckillSession) {
		seckillSession.setId(id);
		return seckillSessionMapper.updateByPrimaryKey(seckillSession);
	}

	@Override
	public SmsSeckillSession getById(Long id) {
		return seckillSessionMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SmsSeckillSession> list(Integer pageSize, Integer pageNum, List<Long> ids) {
		PageHelper.startPage(pageNum, pageSize);
		SmsSeckillSessionExample example = new SmsSeckillSessionExample();
		example.createCriteria().andIdIn(ids);
		return seckillSessionMapper.selectByExample(example);
	}

	@Override
	public List<SmsSeckillSession> getLates3DaySession() {
		//计算最近三天
		//查出这三天参加秒杀活动的商品
		Date now = new Date();
		SmsSeckillSessionExample example = new SmsSeckillSessionExample();
		example.createCriteria().andStartTimeBetween(now, get3DayTime(now));
		List<SmsSeckillSession> list = seckillSessionMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			List<SmsSeckillSession> collect = list.stream().map(session -> {
				Long id = session.getId();
				//查出sms_seckill_sku_relation关联的skuId
				List<SmsSeckillSkuRelation> relationSkus = seckillSkuRelationService.list(1, 1, null, id);
				session.setRelationSkus(relationSkus);
				return session;
			}).collect(Collectors.toList());
			return collect;
		}
		return null;
	}

	public Date get3DayTime(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.HOUR, ca.get(Calendar.HOUR) + 72);
		return ca.getTime();
	}

}
