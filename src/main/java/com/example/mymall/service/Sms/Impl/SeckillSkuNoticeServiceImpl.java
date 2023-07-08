package com.example.mymall.service.Sms.Impl;

import com.example.mymall.mbg.mapper.SmsSeckillSkuNoticeMapper;
import com.example.mymall.mbg.model.SmsSeckillSkuNotice;
import com.example.mymall.mbg.model.SmsSeckillSkuNoticeExample;
import com.example.mymall.service.Sms.SeckillSkuNoticeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-07-08 14:00
 **/
@Service
public class SeckillSkuNoticeServiceImpl implements SeckillSkuNoticeService {
	@Autowired
	SmsSeckillSkuNoticeMapper skuNoticeMapper;

	@Override
	public List<SmsSeckillSkuNotice> list(Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageSize, pageNum);
		return skuNoticeMapper.selectByExample(new SmsSeckillSkuNoticeExample());
	}
}
