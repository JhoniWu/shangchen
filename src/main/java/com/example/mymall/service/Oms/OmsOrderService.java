package com.example.mymall.service.Oms;

import com.example.mymall.dto.Oms.*;
import com.example.mymall.mbg.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: MyMall
 * @description: 订单service
 * @author: Max Wu
 * @create: 2023-07-03 08:45
 **/
public interface OmsOrderService {
	/**
	 * 订单查询
	 */
	List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum);

	/**
	 * 批量发货
	 */
	@Transactional
	int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

	/**
	 * 批量关闭订单
	 */
	@Transactional
	int close(List<Long> ids, String note);

	/**
	 * 批量删除订单
	 */
	int delete(List<Long> ids);

	/**
	 * 获取指定订单详情
	 */
	OmsOrderDetail detail(Long id);

	/**
	 * 修改订单收货人信息
	 */
	@Transactional
	int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

	/**
	 * 修改订单费用信息
	 */
	@Transactional
	int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

	/**
	 * 修改订单备注
	 */
	@Transactional
	int updateNote(Long id, String note, Integer status);
}