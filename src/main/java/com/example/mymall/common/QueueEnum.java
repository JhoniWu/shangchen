package com.example.mymall.common;

import lombok.Getter;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-07-06 17:32
 **/
@Getter
public enum QueueEnum {
	/**
	 * 消息通知队列
	 */
	QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
	/**
	 * 消息通知ttl队列
	 */
	QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");

	/**
	 * 交换名称
	 */
	private final String exchange;
	/**
	 * 队列名称
	 */
	private final String name;
	/**
	 * 路由键
	 */
	private final String routeKey;

	QueueEnum(String exchange, String name, String routeKey) {
		this.exchange = exchange;
		this.name = name;
		this.routeKey = routeKey;
	}
}
