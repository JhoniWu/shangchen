package com.example.mymall.controller;

import com.example.mymall.common.CommonResult;
import com.example.mymall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: MyMall
 * @description: 会员登录注册管理Controller
 * @author: Max Wu
 * @create: 2023-03-11 21:41
 **/
@Controller
@Api(tags = "UmsMemberController" , description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {
	@Autowired
	private UmsMemberService memberService;

	@ApiOperation("获取验证码")
	@RequestMapping(value = "getAuthCode", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult getAuthCode(@RequestParam String telephone){
		return memberService.generateAuthCode(telephone);
	}

	@ApiOperation("判断校验码是否正确")
	@RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult updatePassword(@RequestParam String telephone ,
									   @RequestParam String authCode) {
		return memberService.verifyAuthCode(telephone,authCode);
	}
}
