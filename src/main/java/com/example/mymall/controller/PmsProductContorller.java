package com.example.mymall.controller;

import com.example.mymall.common.CommonPage;
import com.example.mymall.common.CommonResult;
import com.example.mymall.dto.PmsProductParam;
import com.example.mymall.dto.PmsProductQueryParam;
import com.example.mymall.dto.PmsProductResult;
import com.example.mymall.mbg.model.PmsProduct;
import com.example.mymall.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品管理Controller
 * @author: Max Wu
 * @create: 2023-05-04 20:10
 **/
@RestController
@Api(tags = "PmsProductController", description = "商品管理")
@RequestMapping("/product")
public class PmsProductContorller {
	@Autowired
	private PmsProductService productService;

	@ApiOperation("创建商品")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult create(@RequestBody PmsProductParam productParam) {
		int count = productService.create(productParam);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("更新商品")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult update(@PathVariable("id") Long id, @RequestBody PmsProductParam productParam) {
		int count = productService.update(id, productParam);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("查询商品")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<CommonPage<PmsProduct>> getList(PmsProductQueryParam pmsProductQueryParam,
														@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
														@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		List<PmsProduct> products = productService.getList(pmsProductQueryParam, pageNum, pageSize);
		return CommonResult.success(CommonPage.restPage(products));
	}

	@ApiOperation("根据商品id获取商品编辑信息")
	@RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<PmsProductResult> getUpdateInfo(@PathVariable("id") Long id) {
		PmsProductResult productResult = productService.getUpdateInfo(id);
		return CommonResult.success(productResult);
	}

	@ApiOperation("根据商品名称或者货号模糊查询")
	@RequestMapping(value = "/simpleList", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<PmsProduct>> getList(String keyword) {
		List<PmsProduct> products = productService.list(keyword);
		return CommonResult.success(products);
	}

	@ApiOperation("批量修改审核状态")
	@RequestMapping(value = "/update/verifyStatus", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult updateVerifyStatus(@RequestParam("ids") List<Long> ids,
										   @RequestParam("verifyStatus") Integer verifyStatus,
										   @RequestParam("detail") String detail) {
		int count = productService.UpdateVerifyStatus(ids, verifyStatus, detail);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("批量上下架商品")
	@RequestMapping(value = "/update/publishStatus", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult updatePublishStatus(@RequestParam("ids") List<Long> ids,
											@RequestParam("publishStatus") Integer publishStatus) {
		int count = productService.updatePublishStatus(ids, publishStatus);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("批量推荐商品")
	@RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,
											  @RequestParam("recommendStatus") Integer status) {
		int count = productService.updateRecommendStatus(ids, status);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}


	@ApiOperation("批量设为新品")
	@RequestMapping(value = "/update/newStatus", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult updateNewStatus(@RequestParam("ids") List<Long> ids,
										@RequestParam("newStatus") Integer status) {
		int count = productService.updateNewStatus(ids, status);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}


	@ApiOperation("批量修改删除状态")
	@RequestMapping(value = "/update/deleteStatus", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult updateDeleteStatus(@RequestParam("ids") List<Long> ids,
										   @RequestParam("deleteStatus") Integer status) {
		int count = productService.deleteStatus(ids, status);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}
}
