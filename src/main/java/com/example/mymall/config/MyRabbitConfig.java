package com.example.mymall.config;


import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: MyMall
 * @description: rabbitmq配置类
 * @author: Max Wu
 * @create: 2023-07-01 17:26
 **/
@Configuration
public class MyRabbitConfig {
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}