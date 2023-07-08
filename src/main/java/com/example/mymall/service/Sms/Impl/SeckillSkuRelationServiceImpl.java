package com.example.mymall.service.Sms.Impl;

import com.example.mymall.mbg.mapper.SmsSeckillSkuRelationMapper;
import com.example.mymall.mbg.model.SmsSeckillSkuRelation;
import com.example.mymall.mbg.model.SmsSeckillSkuRelationExample;
import com.example.mymall.service.Sms.SeckillSkuRelationService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-07-08 13:40
 **/
@Service
public class SeckillSkuRelationServiceImpl implements SeckillSkuRelationService {
	@Autowired
	private SmsSeckillSkuRelationMapper seckillSkuRelationMapper;

	@Override
	public List<SmsSeckillSkuRelation> list(Integer pageSize, Integer pageNum, Long id, Long promotionSessionId) {
		PageHelper.startPage(pageNum, pageSize);
		SmsSeckillSkuRelationExample example = new SmsSeckillSkuRelationExample();
		if (id != null) {
			example.createCriteria().andIdEqualTo(id);
		}
		if (promotionSessionId != null) {
			example.createCriteria().andPromotionIdEqualTo(promotionSessionId);
		}
		return seckillSkuRelationMapper.selectByExample(example);
	}

	@Override
	public int add(SmsSeckillSkuRelation skuRelation) {
		return seckillSkuRelationMapper.insert(skuRelation);
	}

	@Override
	public int delete(List<Long> ids) {
		SmsSeckillSkuRelationExample example = new SmsSeckillSkuRelationExample();
		example.createCriteria().andIdIn(ids);
		return seckillSkuRelationMapper.deleteByExample(example);
	}

	@Override
	public int update(Long id, SmsSeckillSkuRelation skuRelation) {
		skuRelation.setId(id);
		return seckillSkuRelationMapper.updateByPrimaryKey(skuRelation);
	}

	@Override
	public SmsSeckillSkuRelation getById(Long id) {
		return seckillSkuRelationMapper.selectByPrimaryKey(id);
	}
}
