package com.example.mymall.dao;

import com.example.mymall.dto.portal.SmsCouponHistoryDetail;
import com.example.mymall.mbg.model.SmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 会员优惠券领取自定义dao
 * @author: Max Wu
 * @create: 2023-07-06 16:38
 **/
public interface SmsCouponHistoryDao {
	/**
	 * 获取优惠券历史详情
	 */
	List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);

	/**
	 * 获取指定会员的优惠券列表
	 */
	List<SmsCoupon> getCouponList(@Param("memberId") Long memberId, @Param("useStatus") Integer useStatus);

}
