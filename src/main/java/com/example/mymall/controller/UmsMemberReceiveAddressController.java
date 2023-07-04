package com.example.mymall.controller;

import com.example.mymall.common.CommonResult;
import com.example.mymall.mbg.model.UmsMemberReceiveAddress;
import com.example.mymall.service.Ums.UmsMemberReceiveAddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description: 用户收获地址controller
 * @author: Max Wu
 * @create: 2023-07-03 09:26
 **/
@RestController
@Api(tags = "UmsMemberReceiveAddressController", description = "用户收货地址管理")
@RequestMapping("/member/address")
public class UmsMemberReceiveAddressController {
	@Autowired
	private UmsMemberReceiveAddressService addressService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonResult addAddress(@RequestBody UmsMemberReceiveAddress address) {
		int count = addressService.add(address);
		if (count > 0) {
			return CommonResult.success("add success");
		}
		return CommonResult.failed("failed");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public CommonResult deleteAddress(@RequestParam("id") Integer id) {
		return CommonResult.success("");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public CommonResult updateAddress(@RequestParam("id") Long id,
									  @RequestBody UmsMemberReceiveAddress address) {
		int count = addressService.update(id, address);
		if (count > 0)
			return CommonResult.success("");
		return CommonResult.failed();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public CommonResult<List<UmsMemberReceiveAddress>> listAddress() {
		List<UmsMemberReceiveAddress> list = addressService.list();
		return CommonResult.success(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CommonResult<UmsMemberReceiveAddress> getInfoAddress(@PathVariable("id") Long id) {
		return CommonResult.success(addressService.getItem(id));
	}


}
