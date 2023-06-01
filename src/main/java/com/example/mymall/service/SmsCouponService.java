package com.example.mymall.service;

import com.example.mymall.dto.SmsCouponParam;
import com.example.mymall.mbg.model.SmsCoupon;
import com.example.mymall.mbg.model.SmsCouponHistory;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-05-31 16:27
 **/
public interface SmsCouponService {
	int createCoupon(SmsCouponParam coupon);

	SmsCoupon updateCoupon(Long id, SmsCoupon coupon);

	void deleteCoupon(Long id);

	List<SmsCoupon> getAllCoupons();

	SmsCoupon getCouponById(Long id);

	List<SmsCoupon> getCouponByType(int type);

	/**
	 * 会员使用优惠券。参数包含要使用的优惠券的 ID 以及会员的 ID
	 *
	 * @param id
	 * @param memberId
	 * @return
	 */
	SmsCoupon useCoupon(Long id, Long memberId);

	List<SmsCoupon> getCouponByMemberId(Long memberId);

	List<SmsCouponHistory> getCouponHistoryByCouponId(Long couponId, Integer userStatus, String orderSn, Integer pageSize, Integer pageNum);

	List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);
}
