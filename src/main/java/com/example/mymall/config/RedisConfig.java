package com.example.mymall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @program: MyMall
 * @description: redistemplate配置类
 * @author: Max Wu
 * @create: 2023-06-29 10:16
 **/
@Configuration
public class RedisConfig {
	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate redisTemplate = new RedisTemplate();
		//设置序列化Key的实例化对象解决key出现乱码的问题
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//设置序列化Value的实例化对象
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		//设置连接工厂
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}
}
