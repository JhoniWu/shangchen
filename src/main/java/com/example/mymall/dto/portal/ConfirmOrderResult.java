package com.example.mymall.dto.portal;

import com.example.mymall.mbg.model.UmsIntegrationConsumeSetting;
import com.example.mymall.mbg.model.UmsMemberReceiveAddress;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: MyMall
 * @description: 确认单信息封装
 * @author: Max Wu
 * @create: 2023-07-05 15:13
 **/
@Data
public class ConfirmOrderResult {
	@ApiModelProperty("包含优惠信息的购物车信息")
	private List<CartPromotionItem> cartPromotionItemList;
	@ApiModelProperty("用户收获地址列表")
	private List<UmsMemberReceiveAddress> memberReceiveAddresses;
	@ApiModelProperty("用户可用优惠券列表")
	private List<SmsCouponHistoryDetail> couponHistoryDetailList;
	@ApiModelProperty("积分使用规则")
	private UmsIntegrationConsumeSetting integrationConsumeSetting;
	@ApiModelProperty("会员持有积分")
	private Integer memberIntegration;
	@ApiModelProperty("计算的金额")
	private CalcAmount calcAmount;

	@Data
	public static class CalcAmount {
		@ApiModelProperty("订单商品总金额")
		private BigDecimal totalAmount;
		@ApiModelProperty("运费")
		private BigDecimal freightAmount;
		@ApiModelProperty("活动优惠")
		private BigDecimal promotionAmount;
		@ApiModelProperty("应付金额")
		private BigDecimal payAmount;
	}
}
