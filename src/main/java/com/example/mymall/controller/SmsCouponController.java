package com.example.mymall.controller;

import com.example.mymall.common.CommonPage;
import com.example.mymall.common.CommonResult;
import com.example.mymall.dto.SmsCouponParam;
import com.example.mymall.mbg.model.SmsCoupon;
import com.example.mymall.mbg.model.SmsCouponHistory;
import com.example.mymall.service.SmsCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description: 优惠券操作
 * @author: Max Wu
 * @create: 2023-06-01 15:56
 **/
@RestController
@Api(tags = "SmsCouponController", description = "优惠券管理")
@RequestMapping("/coupon")
public class SmsCouponController {
	@Autowired
	private SmsCouponService smsCouponService;

	@ApiOperation("添加优惠券")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult add(@RequestBody SmsCouponParam smsCouponParam) {
		int count = smsCouponService.createCoupon(smsCouponParam);
		if (count > 0) return CommonResult.success(count);
		return CommonResult.failed();
	}

	@ApiOperation("删除优惠券")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public CommonResult delete(@RequestParam("id") Long id) {
		smsCouponService.deleteCoupon(id);
		return CommonResult.success("删除成功");
	}

	@ApiOperation("修改优惠券")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult update(@RequestParam("id") Long id, @RequestBody SmsCoupon couponParam) {
		SmsCoupon coupon = smsCouponService.updateCoupon(id, couponParam);
		if (coupon != null) return CommonResult.success(coupon);
		return CommonResult.failed();
	}

	@ApiOperation("根据优惠券名称和类型分页获取优惠券列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<CommonPage<SmsCoupon>> list(@RequestParam(value = "name", required = false) String name,
													@RequestParam(value = "type", required = false) Integer type,
													@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
													@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		List<SmsCoupon> couponList = smsCouponService.list(name, type, pageSize, pageNum);
		return CommonResult.success(CommonPage.restPage(couponList));
	}

	@ApiOperation("获取单个优惠券的详情信息")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<SmsCoupon> getItem(@PathVariable Long id) {
		return CommonResult.success(smsCouponService.getCouponById(id));
	}

	@ApiOperation("根据优惠券id，使用状态，订单编号分页获取领取记录")
	@RequestMapping(value = "/history/list", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<CommonPage<SmsCouponHistory>> listHistory(@RequestParam(value = "couponId", required = false) Long couponId,
																  @RequestParam(value = "useStatus", required = false) Integer useStatus,
																  @RequestParam(value = "orderSn", required = false) String orderSn,
																  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
																  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		List<SmsCouponHistory> historyList = smsCouponService.getCouponHistoryByCouponId(couponId, useStatus, orderSn, pageSize, pageNum);
		return CommonResult.success(CommonPage.restPage(historyList));
	}
}
