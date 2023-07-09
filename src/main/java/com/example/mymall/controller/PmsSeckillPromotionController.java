package com.example.mymall.controller;

import com.example.mymall.service.Sms.SeckillPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: MyMall
 * @description: 秒杀活动
 * @author: Max Wu
 * @create: 2023-07-09 15:11
 **/
@RestController
@RequestMapping("/seckillAdmin")
public class PmsSeckillPromotionController {
	@Autowired
	private SeckillPromotionService promotionService;
	//TODO CRUD
}
