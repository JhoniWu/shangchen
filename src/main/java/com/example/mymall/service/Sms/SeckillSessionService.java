package com.example.mymall.service.Sms;

import com.example.mymall.mbg.model.SmsSeckillSession;

import java.util.List;

/**
 * @program: MyMall
 * @description: 秒杀活动场次
 * @author: Max Wu
 * @create: 2023-07-08 13:14
 **/
public interface SeckillSessionService {
	int add(SmsSeckillSession seckillSession);

	int delete(List<Long> ids);

	int update(Long id, SmsSeckillSession seckillSession);

	SmsSeckillSession getById(Long id);

	List<SmsSeckillSession> list(Integer pageSize, Integer pageNum, List<Long> ids);

	List<SmsSeckillSession> getLates3DaySession();
}
