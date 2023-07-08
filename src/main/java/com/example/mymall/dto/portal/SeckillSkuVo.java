package com.example.mymall.dto.portal;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-07-08 21:58
 **/
@Data
public class SeckillSkuVo {

	private Long id;
	/**
	 * 活动id
	 */
	private Long promotionId;
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
	 * 秒杀总量
	 */
	private Integer seckillCount;
	/**
	 * 每人限购数量
	 */
	private Integer seckillLimit;
	/**
	 * 排序
	 */
	private Integer seckillSort;

}
