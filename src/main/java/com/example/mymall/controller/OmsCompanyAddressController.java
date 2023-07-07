package com.example.mymall.controller;

import com.example.mymall.common.CommonResult;
import com.example.mymall.mbg.model.OmsCompanyAddress;
import com.example.mymall.service.Oms.OmsCompanyAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: MyMall
 * @description: 收获地址controller
 * @author: Max Wu
 * @create: 2023-07-04 14:37
 **/
@Controller
@Api(tags = "OmsCompanyAddressController", description = "收货地址管理")
@RequestMapping("/companyAddress")
public class OmsCompanyAddressController {
	@Autowired
	OmsCompanyAddressService companyAddressService;

	@ApiOperation("获取所有收货地址")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<OmsCompanyAddress>> list() {
		List<OmsCompanyAddress> companyAddressList = companyAddressService.list();
		return CommonResult.success(companyAddressList);
	}
}
