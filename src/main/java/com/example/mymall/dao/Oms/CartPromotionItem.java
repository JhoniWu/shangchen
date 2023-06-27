package com.example.mymall.dao.Oms;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: MyMall
 * @description: 购物车促销信息的封装
 * @author: Max Wu
 * @create: 2023-06-27 15:19
 **/
@Data
public class CartPromotionItem {
	@ApiModelProperty("促销活动信息")
	private String promotionMessage;
	@ApiModelProperty("促销活动减去的金额，针对每个商品")
	private BigDecimal reduceAmount;
	@ApiModelProperty("剩余库存-锁定库存")
	private Integer realStock;
	@ApiModelProperty("购买商品赠送积分")
	private Integer integration;
	@ApiModelProperty("购买商品赠送成长值")
	private Integer growth;
}
