package com.example.mymall.controller.PmsProduct;

import com.example.mymall.common.CommonPage;
import com.example.mymall.common.CommonResult;
import com.example.mymall.controller.PmsBrandController;
import com.example.mymall.mbg.model.PmsProductCategory;

import com.example.mymall.service.PmsProduct.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-04-26 19:40
 **/
@Api(tags = "PmsProductCategoryController", description = "商品分类管理")
@Controller
@RequestMapping("/productCategory")
public class PmsProductCategoryController {
	@Autowired
	private PmsProductCategoryService pmsProductCategoryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductCategoryController.class);

	@ApiOperation("获取所有商品分类")
	@RequestMapping(value = "listAll",method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<PmsProductCategory>> getCategory(){
		return CommonResult.success(pmsProductCategoryService.listAllCategory());
	}

	@ApiOperation("添加商品分类")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult createCategory(@RequestBody PmsProductCategory pmsProductCategory){
		CommonResult commonResult;
		int count = pmsProductCategoryService.createCategory(pmsProductCategory);
		if(count==1) {
			commonResult = CommonResult.success(pmsProductCategory);
			LOGGER.debug("createCategory success:{}", pmsProductCategory);
		} else {
			commonResult = CommonResult.failed("操作失败");
			LOGGER.debug("createCategory failed:{}", pmsProductCategory);
		}
		return commonResult;
	}

	@ApiOperation("更新商品分类")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult updateCategory(@PathVariable("id") Long id, @RequestBody PmsProductCategory pmsProductCategory){
		CommonResult commonResult;
		int count = pmsProductCategoryService.updateCategory(id,pmsProductCategory);
		if(count==1) {
			commonResult = CommonResult.success(pmsProductCategory);
			LOGGER.debug("updateCategory success:{}", pmsProductCategory);
		} else {
			commonResult = CommonResult.failed("操作失败");
			LOGGER.debug("updateCategory failed:{}", pmsProductCategory);
		}
		return commonResult;
	}

	@ApiOperation("删除商品分类")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult deleteCategory(@PathVariable("id") Long id){
		int count = pmsProductCategoryService.deleteCategory(id);
		if(count==1) {
			LOGGER.debug("deleteCategory success :id={}",id);
			return CommonResult.success(null);
		} else {
			LOGGER.debug("deleteCategory failed :id={}",id);
			return CommonResult.failed("操作失败");
		}
	}

	@ApiOperation("分页查询分类列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<CommonPage<PmsProductCategory>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("页码") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "3") @ApiParam("每页数量") Integer pageSize) {
		List<PmsProductCategory> cateList = pmsProductCategoryService.listCateGory(pageNum,pageSize);
		return CommonResult.success(CommonPage.restPage(cateList));
	}

	@ApiOperation("获取指定id的分裂列表")
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<PmsProductCategory> category(@PathVariable("id") Long id) {
		return CommonResult.success(pmsProductCategoryService.getCategory(id));
	}
}
