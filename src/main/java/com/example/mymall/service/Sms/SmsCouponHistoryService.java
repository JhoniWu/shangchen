package com.example.mymall.service.Sms;

import com.example.mymall.mbg.model.SmsCouponHistory;

import java.util.List;

/**
 * @program: MyMall
 * @description: 优惠券领取记录管理
 * @author: Max Wu
 * @create: 2023-07-07 16:52
 **/
public interface SmsCouponHistoryService {
	/**
	 * 分页查询优惠券领取记录
	 *
	 * @param couponId  优惠券id
	 * @param useStatus 使用状态
	 * @param orderSn   使用订单号码
	 */
	List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum);
}
