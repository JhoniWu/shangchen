package com.example.mymall.service.Sms.Impl;

import cn.hutool.core.util.StrUtil;
import com.example.mymall.mbg.mapper.SmsCouponHistoryMapper;
import com.example.mymall.mbg.model.SmsCouponHistory;
import com.example.mymall.mbg.model.SmsCouponHistoryExample;
import com.example.mymall.service.Sms.SmsCouponHistoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: MyMall
 * @description: 优惠券领取记录管理
 * @author: Max Wu
 * @create: 2023-07-07 16:53
 **/
public class SmsCouponHistoryServiceImpl implements SmsCouponHistoryService {
	@Autowired
	private SmsCouponHistoryMapper couponHistoryMapper;

	@Override
	public List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		SmsCouponHistoryExample example = new SmsCouponHistoryExample();
		SmsCouponHistoryExample.Criteria criteria = example.createCriteria();
		if (couponId != null) {
			criteria.andCouponIdEqualTo(couponId);
		}
		if (useStatus != null) {
			criteria.andUseStatusEqualTo(useStatus);
		}
		if (!StrUtil.isEmpty(orderSn)) {
			criteria.andOrderSnEqualTo(orderSn);
		}
		return couponHistoryMapper.selectByExample(example);
	}
}
