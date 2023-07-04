package com.example.mymall;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
class MyMallApplicationTests {

	@Autowired
	AmqpAdmin amqpAdmin;

	@Autowired
	RabbitTemplate rabbitTemplate;


	@Test
	void createExchange() {
		DirectExchange directExchange = new DirectExchange("hello-java-exchange", true, false);
		amqpAdmin.declareExchange(directExchange);
		log.info("Exchange create success");
	}


}
