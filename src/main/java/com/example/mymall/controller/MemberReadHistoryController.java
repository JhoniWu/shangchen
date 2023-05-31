package com.example.mymall.controller;

import com.example.mymall.common.CommonResult;
import com.example.mymall.nosql.mongodb.document.MemberReadHistory;
import com.example.mymall.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description: 会员商品浏览记录Controller
 * @author: Max Wu
 * @create: 2023-05-08 16:16
 **/
@RestController
@Api(tags = "MemberReadHistoryController", description = "会员商品浏览记录管理")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {
	@Autowired
	private MemberReadHistoryService memberReadHistoryService;

	@ApiOperation("创建浏览记录")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult create(@RequestBody MemberReadHistory memberReadHistory) {
		int count = memberReadHistoryService.create(memberReadHistory);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("删除浏览记录")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public CommonResult delete(@RequestParam("ids") List<String> ids) {
		int count = memberReadHistoryService.delete(ids);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("展示浏览记录")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<MemberReadHistory>> list(Long memberId) {
		List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.list(memberId);
		return CommonResult.success(memberReadHistoryList);
	}

}

