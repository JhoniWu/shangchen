package com.example.mymall.service.Sms;

import com.example.mymall.mbg.model.SmsSeckillSkuRelation;

import java.util.List;

/**
 * @program: MyMall
 * @description: 秒杀活动商品关联
 * @author: Max Wu
 * @create: 2023-07-08 13:39
 **/
public interface SeckillSkuRelationService {
	List<SmsSeckillSkuRelation> list(Integer pageSize, Integer pageNum, Long id, Long promotionSessionId);

	int add(SmsSeckillSkuRelation skuRelation);

	int delete(List<Long> ids);

	int update(Long id, SmsSeckillSkuRelation skuRelation);

	SmsSeckillSkuRelation getById(Long id);
}
