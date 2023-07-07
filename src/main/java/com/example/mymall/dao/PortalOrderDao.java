package com.example.mymall.dao;

import com.example.mymall.dto.OmsOrderDetail;
import com.example.mymall.mbg.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 前台订单管理自定义dao
 * @author: Max Wu
 * @create: 2023-07-06 16:51
 **/
public interface PortalOrderDao {
	/**
	 * 获取订单以及下单详情
	 */
	OmsOrderDetail getDetail(@Param("orderId") Long orderId);

	/**
	 * 修改pms_sku_stock表的锁定库存以及真实库存
	 */
	int updateSkuStock(@Param("itemList") List<OmsOrderItem> orderItemList);

	/**
	 * 获取超时订单
	 */
	List<OmsOrderDetail> getTimeOutOrders(@Param("minute") Integer minute);

	/**
	 * 批量修改订单状态
	 */
	int updateOrderStatus(@Param("ids") List<Long> ids, @Param("status") Integer status);

	/**
	 * 解除取消订单的库存锁定
	 */
	int releaseSkuStockLock(@Param("itemList") List<OmsOrderItem> orderItemList);
}
