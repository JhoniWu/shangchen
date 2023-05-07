package com.example.mymall.controller;

import com.example.mymall.common.CommonPage;
import com.example.mymall.common.CommonResult;
import com.example.mymall.mbg.model.PmsProductAttributeCategory;
import com.example.mymall.service.PmsProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品属性分类管理Controller
 * @author: Max Wu
 * @create: 2023-04-30 21:18
 **/
@RestController
@Api(tags = "PmsProductAttributeCategoryController", description = "商品属性分类管理")
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {
	@Autowired
	private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

	@ApiOperation("根据Id查询某个商品的属性分类")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CommonResult<PmsProductAttributeCategory> selectById(@PathVariable Long id) {
		PmsProductAttributeCategory pmsProductAttributeCategory = pmsProductAttributeCategoryService.getAttributeCategory(id);
		return CommonResult.success(pmsProductAttributeCategory);
	}

	@ApiOperation("修改商品属性分类")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public CommonResult update(@PathVariable Long id, @RequestBody PmsProductAttributeCategory pmsProductAttributeCategory) {
		int count = pmsProductAttributeCategoryService.updateAttributeCategory(id, pmsProductAttributeCategory);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("添加商品属性分类")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult create(@RequestParam("name") String name) {
		int count = pmsProductAttributeCategoryService.createAttributeCategory(name);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("删除商品属性分类")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public CommonResult delete(@PathVariable("id") Long id) {
		int count = pmsProductAttributeCategoryService.deleteAttributeCategory(id);
		if (count > 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("获取商品属性分类列表")
	@RequestMapping(value = "/list/withAttr", method = RequestMethod.GET)
	public CommonResult<List<PmsProductAttributeCategory>> getList() {
		List<PmsProductAttributeCategory> productAttributeCategories = pmsProductAttributeCategoryService.listAllAttributeCategory();
		return CommonResult.success(productAttributeCategories);
	}

	@ApiOperation("分页获取商品属性分类列表")
	@RequestMapping()
	public CommonResult<CommonPage<PmsProductAttributeCategory>> getListWithAttr(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
		List<PmsProductAttributeCategory> productAttributeCategories = pmsProductAttributeCategoryService.listAttributeCategory(pageNum, pageSize);
		return CommonResult.success(CommonPage.restPage(productAttributeCategories));
	}
}
