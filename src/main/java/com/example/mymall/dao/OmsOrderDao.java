package com.example.mymall.dao;

import com.example.mymall.dto.Oms.OmsOrderDeliveryParam;
import com.example.mymall.dto.Oms.OmsOrderDetail;
import com.example.mymall.dto.Oms.OmsOrderQueryParam;
import com.example.mymall.mbg.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-07-03 15:02
 **/
public interface OmsOrderDao {
	/**
	 * 条件查询订单
	 */
	List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);


	/**
	 * 批量发货
	 */
	int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

	/**
	 * 获取订单详情
	 */
	OmsOrderDetail getDetail(@Param("id") Long id);

}
