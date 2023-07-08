package com.example.mymall.service.Sms;

import com.example.mymall.mbg.model.SmsSeckillSkuNotice;

import java.util.List;

/**
 * @program: MyMall
 * @description: noticeSku
 * @author: Max Wu
 * @create: 2023-07-08 13:59
 **/
public interface SeckillSkuNoticeService {
	List<SmsSeckillSkuNotice> list(Integer pageSize, Integer pageNum);
}
