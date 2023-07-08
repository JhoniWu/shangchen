package com.example.mymall.service.Sms;

import com.example.mymall.mbg.model.SmsSeckillPromotion;

import java.util.List;

/**
 * @program: MyMall
 * @description: 秒杀活动
 * @author: Max Wu
 * @create: 2023-07-08 13:06
 **/
public interface SeckillPromotionService {
	List<SmsSeckillPromotion> list(Integer pageSize, Integer PageNum, List<Long> ids);

	int add(SmsSeckillPromotion seckillPromotion);

	int delete(List<Long> ids);

	int update(Long id, SmsSeckillPromotion seckillPromotion);

	SmsSeckillPromotion getById(Long id);
}
