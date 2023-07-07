package com.example.mymall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: MyMall
 * @description: 订单发货参数
 * @author: Max Wu
 * @create: 2023-07-03 08:51
 **/
@Data
public class OmsOrderDeliveryParam {
	@ApiModelProperty("订单id")
	private Long orderId;
	@ApiModelProperty("物流公司")
	private String deliveryCompany;
	@ApiModelProperty("物流单号")
	private String deliverySn;
}
