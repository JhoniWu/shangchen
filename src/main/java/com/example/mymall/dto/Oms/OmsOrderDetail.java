package com.example.mymall.dto.Oms;

import com.example.mymall.mbg.model.OmsOrder;
import com.example.mymall.mbg.model.OmsOrderItem;
import com.example.mymall.mbg.model.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: MyMall
 * @description: 订单详情信息
 * @author: Max Wu
 * @create: 2023-07-03 08:53
 **/
@Data
public class OmsOrderDetail extends OmsOrder {
	@ApiModelProperty("订单商品列表")
	private List<OmsOrderItem> orderItemList;
	@ApiModelProperty("订单操作记录列表")
	private List<OmsOrderOperateHistory> historyList;
}
