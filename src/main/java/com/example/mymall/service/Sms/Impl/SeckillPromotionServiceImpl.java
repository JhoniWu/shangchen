package com.example.mymall.service.Sms.Impl;

import com.example.mymall.mbg.mapper.SmsSeckillPromotionMapper;
import com.example.mymall.mbg.model.SmsSeckillPromotion;
import com.example.mymall.mbg.model.SmsSeckillPromotionExample;
import com.example.mymall.service.Sms.SeckillPromotionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description: 秒杀活动impl
 * @author: Max Wu
 * @create: 2023-07-08 13:08
 **/
@Service
public class SeckillPromotionServiceImpl implements SeckillPromotionService {
	@Autowired
	private SmsSeckillPromotionMapper seckillPromotionMapper;

	@Override
	public List<SmsSeckillPromotion> list(Integer pageSize, Integer PageNum, List<Long> ids) {
		PageHelper.startPage(pageSize, PageNum);
		SmsSeckillPromotionExample example = new SmsSeckillPromotionExample();
		example.createCriteria().andIdIn(ids);
		return seckillPromotionMapper.selectByExample(example);
	}

	@Override
	public int add(SmsSeckillPromotion seckillPromotion) {
		return seckillPromotionMapper.insert(seckillPromotion);
	}

	@Override
	public int delete(List<Long> ids) {
		SmsSeckillPromotionExample example = new SmsSeckillPromotionExample();
		example.createCriteria().andIdIn(ids);
		return seckillPromotionMapper.deleteByExample(example);
	}

	@Override
	public int update(Long id, SmsSeckillPromotion seckillPromotion) {
		seckillPromotion.setId(id);
		return seckillPromotionMapper.updateByPrimaryKey(seckillPromotion);
	}

	@Override
	public SmsSeckillPromotion getById(Long id) {
		return seckillPromotionMapper.selectByPrimaryKey(id);
	}
}
