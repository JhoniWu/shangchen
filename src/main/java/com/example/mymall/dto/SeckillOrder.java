package com.example.mymall.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-07-08 23:01
 **/
@Data
public class SeckillOrder {

	/**
	 * 订单号
	 */
	private String orderSn;

	/**
	 * 活动场次id
	 */
	private Long promotionSessionId;
	/**
	 * 商品id
	 */
	private Long skuId;
	/**
	 * 秒杀价格
	 */
	private BigDecimal seckillPrice;

	/**
	 * 购买数量
	 */
	private Integer num;

	/**
	 * 会员ID
	 */
	private Long memberId;
}
