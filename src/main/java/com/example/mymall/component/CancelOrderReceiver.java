package com.example.mymall.component;

import com.example.mymall.service.Oms.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: MyMall
 * @description: 取消订单消息处理者
 * @author: Max Wu
 * @create: 2023-07-07 13:41
 **/
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
	private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
	@Autowired
	private OmsPortalOrderService portalOrderService;

	@RabbitHandler
	public void handle(Long orderId) {
		LOGGER.info("receive delay message orderId:{}", orderId);
		portalOrderService.cancelOrder(orderId);
	}
}
