package com.example.mymall.listener;

import com.example.mymall.service.Oms.OmsPortalOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: MyMall
 * @description: 秒杀监听端口
 * @author: Max Wu
 * @create: 2023-07-08 21:53
 **/
@Slf4j
@Component
@RabbitListener(queues = "order.seckill.order.queue")
public class OrderSeckillListener {
	@Autowired
	private OmsPortalOrderService orderService;

}
