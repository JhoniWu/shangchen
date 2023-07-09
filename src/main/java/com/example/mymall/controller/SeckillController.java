package com.example.mymall.controller;

import com.example.mymall.common.CommonResult;
import com.example.mymall.dto.portal.SeckillSkuRedisTo;
import com.example.mymall.service.Seckill.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品秒杀Portal
 * @author: Max Wu
 * @create: 2023-07-09 15:00
 **/
@RestController
@RequestMapping("/seckill")
public class SeckillController {
	@Autowired
	private SeckillService seckillService;

	/**
	 * 当前时间可以参与秒杀的商品信息
	 *
	 * @return
	 */
	@RequestMapping(value = "/getSkus", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<SeckillSkuRedisTo>> getCurrentSkus() {
		return CommonResult.success(seckillService.getCurrentSeckillSkus());
	}

	@RequestMapping(value = "/sku/seckill/{skuId}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult getSkuSeckillInfo(@PathVariable("skuId") Long skuId) {
		SeckillSkuRedisTo to = seckillService.getSkuSeckillInfo(skuId);
		return CommonResult.success(to);
	}

	@GetMapping("/kill")
	public String seckill(@RequestParam("killId") String killId,
						  @RequestParam("key") String key,
						  @RequestParam("num") Integer num) throws InterruptedException {
		String orderSn = null;
		orderSn = seckillService.kill(killId, key, num);
		return "success";
	}
}
