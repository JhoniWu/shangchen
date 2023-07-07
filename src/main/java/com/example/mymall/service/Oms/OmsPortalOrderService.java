package com.example.mymall.service.Oms;

import com.example.mymall.common.CommonPage;
import com.example.mymall.dto.OmsOrderDetail;
import com.example.mymall.dto.portal.ConfirmOrderResult;
import com.example.mymall.dto.portal.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @program: MyMall
 * @description: 前台订单管理
 * @author: Max Wu
 * @create: 2023-07-05 15:08
 **/
public interface OmsPortalOrderService {
	/**
	 * 根据用户购物车信息生成确认单
	 */
	ConfirmOrderResult generateConfirmOrder(List<Long> cartIds);

	/**
	 * 根据提交信息生成订单
	 */
	@Transactional
	Map<String, Object> generateOrder(OrderParam orderParam);

	/**
	 * 支付成功后的回调
	 */
	@Transactional
	Integer paySuccess(Long orderId, Integer payType);

	/**
	 * 自动取消超时订单
	 */
	@Transactional
	Integer cancelTimeOutOrder();

	/**
	 * 发送延迟消息取消订单
	 */
	void sendDelayMessageCancelOrder(Long orderId);

	/**
	 * 确认收货
	 */
	void confirmReceiveOrder(Long orderId);

	/**
	 * 分页获取用户订单
	 */
	CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

	/**
	 * 根据订单ID获取订单详情
	 */
	OmsOrderDetail detail(Long orderId);

	/**
	 * 用户根据订单ID删除订单
	 */
	void deleteOrder(Long orderId);

	/**
	 * 取消单个超时订单
	 */
	@Transactional
	void cancelOrder(Long orderId);
}
