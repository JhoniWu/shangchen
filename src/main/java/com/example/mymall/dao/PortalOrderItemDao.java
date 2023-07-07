package com.example.mymall.dao;

import com.example.mymall.mbg.model.OmsOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 订单商品信息管理自定义dao
 * @author: Max Wu
 * @create: 2023-07-06 16:44
 **/
public interface PortalOrderItemDao {
	/**
	 * 批量插入
	 */
	int insertList(@Param("list") List<OmsOrderItem> list);
}
