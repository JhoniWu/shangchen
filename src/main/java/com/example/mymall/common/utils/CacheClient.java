package com.example.mymall.common.utils;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @program: MyMall
 * @description: 缓存工具类
 * @author: Max Wu
 * @create: 2023-05-24 10:47
 **/

@Slf4j
@Component
public class CacheClient {
	private final StringRedisTemplate stringRedisTemplate;

	public CacheClient(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	public void set(String key, Object value, Long time, TimeUnit unit) {
		stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(value), time, unit);
	}

	public void setWithLogicalExpire(String key, Object value, Long time, TimeUnit unit) {
		RedisData redisData = new RedisData();
		redisData.setData(value);
		redisData.setExpireTime(LocalDateTime.now().plusSeconds(unit.toSeconds(time)));
		stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(redisData));
	}

	public <R, ID> R queryWithPassThrough(String keyPrefix, ID id, Class<R> type, Function<ID, R> dbFallback, Long time, TimeUnit unit) {
		String key = keyPrefix + id;
		String json = stringRedisTemplate.opsForValue().get(key);

		if (StrUtil.isNotBlank(json)) {
			return JSONUtil.toBean(json, type);
		}

		if (json != null) {
			return null;
		}

		R r = dbFallback.apply(id);

		if (r == null) {
			stringRedisTemplate.opsForValue().set(key, "", 2L, TimeUnit.MINUTES);
			return null;
		}

		this.set(key, r, time, unit);
		return r;
	}

	public <R, ID> R queryWithLogicalExpire(String keyPrefix, ID id, Class<R> type, Function<ID, R> dbFallback, Long time, TimeUnit unit) {
		String key = keyPrefix + id;
		String json = stringRedisTemplate.opsForValue().get(key);

		if (StrUtil.isBlank(json)) {
			return null;
		}

		RedisData redisData = JSONUtil.toBean(json, RedisData.class);
		R r = JSONUtil.toBean((JSONObject) redisData.getData(), type);
		LocalDateTime expireTime = redisData.getExpireTime();
		if (expireTime.isAfter(LocalDateTime.now())) {
			return r;
		}

		String lockKey = "lock:shop:" + id;
		boolean isLock = tryLock(lockKey);

		if (isLock) {
			CACHE_REBUILD_EXECUTOR.submit(() -> {
				try {
					R apply = dbFallback.apply(id);
					setWithLogicalExpire(key, apply, time, unit);
				} catch (Exception e) {
					throw new RuntimeException();
				} finally {
					unLock(lockKey);
				}
			});
		}
		return r;
	}

	private boolean tryLock(String lockKey) {
		Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "1", 10, TimeUnit.SECONDS);
		return BooleanUtil.isTrue(flag);
	}

	private void unLock(String key) {
		stringRedisTemplate.delete(key);
	}

	private static final ExecutorService CACHE_REBUILD_EXECUTOR = Executors.newFixedThreadPool(10);

}
