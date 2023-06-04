package com.example.mymall.service.Sms.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.example.mymall.dao.SmsCouponProductCategoryRelationDao;
import com.example.mymall.dao.SmsCouponProductRelationDao;
import com.example.mymall.dto.SmsCouponParam;
import com.example.mymall.mbg.mapper.SmsCouponHistoryMapper;
import com.example.mymall.mbg.mapper.SmsCouponMapper;
import com.example.mymall.mbg.mapper.SmsCouponProductCategoryRelationMapper;
import com.example.mymall.mbg.mapper.SmsCouponProductRelationMapper;
import com.example.mymall.mbg.model.*;
import com.example.mymall.service.Sms.SmsCouponService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-05-31 16:51
 **/
@Service
public class SmsCouponServiceImpl implements SmsCouponService {
	@Autowired
	private SmsCouponMapper smsCouponMapper;
	@Autowired
	private SmsCouponHistoryMapper smsCouponHistoryMapper;
	@Autowired
	private SmsCouponProductRelationMapper smsCouponProductRelationMapper;
	@Autowired
	private SmsCouponProductCategoryRelationMapper smsCouponProductCategoryRelationMapper;
	@Autowired
	private SmsCouponProductRelationDao smsCouponProductRelationDao;
	@Autowired
	private SmsCouponProductCategoryRelationDao smsCouponProductCategoryRelationDao;

	@Override
	public int createCoupon(SmsCouponParam coupon) {
		coupon.setCount(coupon.getPublishCount());
		coupon.setUseCount(0);
		coupon.setReceiveCount(0);
		int count = smsCouponMapper.insert(coupon);
		if (coupon.getUseType().equals(2)) {
			for (SmsCouponProductRelation productRelation : coupon.getProductRelationList()) {
				productRelation.setCouponId(coupon.getId());
			}
			smsCouponProductRelationDao.insertList(coupon.getProductRelationList());
		}

		if (coupon.getUseType().equals(1)) {
			for (SmsCouponProductCategoryRelation couponProductCategoryRelation : coupon.getProductCategoryRelationList()) {
				couponProductCategoryRelation.setCouponId(coupon.getId());
			}
			smsCouponProductCategoryRelationDao.insertList(coupon.getProductCategoryRelationList());
		}
		return count;
	}

	@Override
	public SmsCoupon updateCoupon(Long id, SmsCoupon coupon) {
		coupon.setId(id);
		smsCouponMapper.updateByPrimaryKey(coupon);
		return coupon;
	}

	@Override
	public void deleteCoupon(Long id) {
		smsCouponMapper.deleteByPrimaryKey(id);
		deleteProductRelation(id);
		deleteProductCategoryRelation(id);
	}

	private void deleteProductCategoryRelation(Long id) {
		SmsCouponProductCategoryRelationExample example = new SmsCouponProductCategoryRelationExample();
		example.createCriteria().andIdEqualTo(id);
		smsCouponProductCategoryRelationMapper.deleteByExample(example);
	}

	private void deleteProductRelation(Long id) {
		SmsCouponProductRelationExample example = new SmsCouponProductRelationExample();
		example.createCriteria().andIdEqualTo(id);
		smsCouponProductRelationMapper.deleteByExample(example);
	}

	@Override
	public List<SmsCoupon> getAllCoupons() {
		return smsCouponMapper.selectByExample(new SmsCouponExample());
	}

	@Override
	public SmsCoupon getCouponById(Long id) {
		return smsCouponMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SmsCoupon> getCouponByType(int type) {
		SmsCouponExample smsCouponExample = new SmsCouponExample();
		smsCouponExample.createCriteria().andTypeEqualTo(type);
		return smsCouponMapper.selectByExample(smsCouponExample);
	}

	//用户使用优惠券
	@Override
	@Transactional
	public SmsCoupon useCoupon(Long id, Long memberId) {
		SmsCoupon coupon = smsCouponMapper.selectByPrimaryKey(id);
		if (!isCouponCanUse(coupon)) {
			throw new RuntimeException("can not use this coupon");
		}
		coupon.setCount(coupon.getCount() - 1);
		smsCouponMapper.updateByPrimaryKey(coupon);

		SmsCouponHistory couponHistory = createCouponHistory(id, memberId, coupon);
		couponHistory.setUseStatus(1);
		smsCouponHistoryMapper.updateByPrimaryKeySelective(couponHistory);
		return coupon;
	}

	private boolean isCouponCanUse(SmsCoupon coupon) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime startTime = coupon.getStartTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime endTime = coupon.getEndTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		if (now.isAfter(endTime) || now.isBefore(startTime)) {
			return false;
		}
		if (coupon.getCount() <= 0) {
			return false;
		}
		if (coupon.getPerLimit() == 0) {
			return false;
		}
		return true;
	}


	@Override
	public List<SmsCoupon> getCouponByMemberId(Long memberId) {
		SmsCouponHistoryExample history = new SmsCouponHistoryExample();
		history.createCriteria().andMemberIdEqualTo(memberId);
		List<SmsCouponHistory> smsCouponHistories = smsCouponHistoryMapper.selectByExample(history);
		List<SmsCoupon> smsCoupons = new ArrayList<>();
		for (SmsCouponHistory o : smsCouponHistories) {
			Long couponId = o.getCouponId();
			smsCoupons.add(smsCouponMapper.selectByPrimaryKey(couponId));
		}
		return smsCoupons;
	}

	public SmsCouponHistory createCouponHistory(Long id, Long memberId, SmsCoupon coupon) {
		SmsCouponHistory history = new SmsCouponHistory();
		BeanUtil.copyProperties(coupon, history);
		history.setMemberId(memberId);
		history.setCouponId(id);
		history.setCreateTime(new Date());
		smsCouponHistoryMapper.insert(history);
		return history;
	}

	@Override
	public List<SmsCouponHistory> getCouponHistoryByCouponId(Long couponId, Integer userStatus, String orderSn, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		SmsCouponHistoryExample historyExample = new SmsCouponHistoryExample();
		SmsCouponHistoryExample.Criteria criteria = historyExample.createCriteria();
		if (couponId != null) {
			criteria.andCouponIdEqualTo(couponId);
		}
		if (userStatus != null) {
			criteria.andUseStatusEqualTo(userStatus);
		}
		if (!StrUtil.isEmpty(orderSn)) {
			criteria.andOrderSnEqualTo(orderSn);
		}
		return smsCouponHistoryMapper.selectByExample(historyExample);
	}

	@Override
	public List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum) {
		SmsCouponExample example = new SmsCouponExample();
		SmsCouponExample.Criteria criteria = example.createCriteria();
		if (!StrUtil.isEmpty(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		if (type != null) {
			criteria.andTypeEqualTo(type);
		}
		PageHelper.startPage(pageNum, pageSize);
		return smsCouponMapper.selectByExample(example);
	}


}
