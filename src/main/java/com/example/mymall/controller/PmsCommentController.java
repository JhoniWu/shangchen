package com.example.mymall.controller;

import com.example.mymall.common.CommonPage;
import com.example.mymall.common.CommonResult;
import com.example.mymall.mbg.model.PmsComment;
import com.example.mymall.mbg.model.PmsCommentReplay;
import com.example.mymall.service.Pms.PmsCommentReplayService;
import com.example.mymall.service.Pms.PmsCommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品回复模块controller
 * @author: Max Wu
 * @create: 2023-05-07 13:38
 **/
@RestController
@RequestMapping("/comments")
public class PmsCommentController {
	@Autowired
	private PmsCommentReplayService commentReplayService;
	@Autowired
	private PmsCommentService commentService;


	@ApiOperation("获取商品评价列表")
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public CommonResult<CommonPage<PmsComment>> getCommentList(@PathVariable("productId") Long productId,
															   @RequestParam("pageNum") Integer pageNum,
															   @RequestParam("pageSize") Integer pageSize) {
		List<PmsComment> comments = commentService.getList(productId, pageNum, pageSize);
		return CommonResult.success(CommonPage.restPage(comments));
	}

	@ApiOperation("获取商品评价的回复列表")
	@RequestMapping(value = "/{commentId}/replies", method = RequestMethod.GET)
	public CommonResult<List<PmsCommentReplay>> getReplayList(@PathVariable("commentId") Long id) {
		List<PmsCommentReplay> commentReplays = commentReplayService.getList(id);
		return CommonResult.success(commentReplays);
	}

	@ApiOperation("添加商品评价")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public CommonResult addComment(@RequestBody PmsCommentReplay commentReplay) {
		int count = commentReplayService.create(commentReplay);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed("添加失败");
	}

	@ApiOperation("添加商品评价的回复")
	@RequestMapping(value = "/replies", method = RequestMethod.POST)
	public CommonResult addCommentReply(@RequestBody PmsCommentReplay commentReplay) {
		int count = commentReplayService.create(commentReplay);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed("添加失败");
	}

	@ApiOperation("删除某条商品评价")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public CommonResult deleteComment(@PathVariable("id") Long id) {
		int count = commentService.delete(id);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("删除某条商品评价的回复")
	@RequestMapping(value = "/reply/{id}", method = RequestMethod.DELETE)
	public CommonResult deleteCommentReply(@PathVariable("id") Long id) {
		int count = commentReplayService.delete(id);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}
}
