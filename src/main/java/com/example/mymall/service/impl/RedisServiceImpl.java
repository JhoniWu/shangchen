package com.example.mymall.service.impl;

import com.example.mymall.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program: MyMall
 * @description: redis操作Service实现类
 * @author: Max Wu
 * @create: 2023-03-11 21:34
 **/

@Service
public class RedisServiceImpl implements RedisService {
@Autowired
private StringRedisTemplate stringRedisTemplate;

	@Override
	public void set(String key, String value) {
		stringRedisTemplate.opsForValue().set(key,value);
	}

	@Override
	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	@Override
	public boolean expire(String key, long expire) {
		return Boolean.TRUE.equals(stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS));
	}

	@Override
	public void remove(String key) {
		stringRedisTemplate.delete(key);
	}

	@Override
	public Long increment(String key, long delta) {
		return stringRedisTemplate.opsForValue().increment(key,delta);
	}
}
