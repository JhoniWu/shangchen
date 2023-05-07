package com.example.mymall.controller;

import com.example.mymall.common.CommonPage;
import com.example.mymall.common.CommonResult;
import com.example.mymall.dto.ProductAttrInfo;
import com.example.mymall.mbg.model.PmsProductAttribute;
import com.example.mymall.service.PmsProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品属性管理controller
 * @author: Max Wu
 * @create: 2023-04-30 21:18
 **/
@RestController
@Api(tags = "PmsProductAttributeController", description = "商品属性管理")
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {
	@Autowired
	private PmsProductAttributeService pmsProductAttributeService;

	@ApiOperation("根据分类查询属性列表或参数列表")
	@ApiImplicitParams({@ApiImplicitParam(
		name = "type",
		value = "0表示属性，1表示参数",
		required = true, paramType = "query",
		dataType = "integer")})
	@RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
	public CommonResult<CommonPage<PmsProductAttribute>> getList(@PathVariable Long cid,
																 @RequestParam("type") Integer type,
																 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
																 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		List<PmsProductAttribute> productAttributeList = pmsProductAttributeService.listAttribute(pageSize, pageNum);
		if (productAttributeList.get(0) != null) return CommonResult.success(CommonPage.restPage(productAttributeList));
		else return CommonResult.failed("查询失败");
	}

	@ApiOperation("增加商品属性")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public CommonResult create(@RequestBody PmsProductAttribute pmsProductAttribute) {
		int count = pmsProductAttributeService.createAttribute(pmsProductAttribute);
		if (count != 0) return CommonResult.success(count);
		else return CommonResult.failed("增加失败");
	}

	@ApiOperation("批量删除商品属性")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public CommonResult delete(@RequestParam("ids") List<Long> ids) {
		int count = pmsProductAttributeService.deleteIds(ids);
		if (count != 0) return CommonResult.success(count);
		else return CommonResult.failed();
	}

	@ApiOperation("修改商品属性")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public CommonResult update(@PathVariable("id") Long id, @RequestBody PmsProductAttribute pmsProductAttribute) {
		int count = pmsProductAttributeService.updateAttribute(id, pmsProductAttribute);
		if (count > 0) {
			return CommonResult.success(count);
		} else {
			return CommonResult.failed();
		}
	}

	@ApiOperation("根据id查询商品属性")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CommonResult<PmsProductAttribute> selectByid(@PathVariable("id") Long id) {
		int count = 0;
		PmsProductAttribute pmsProductAttribute = pmsProductAttributeService.getAttribute(id);
		return CommonResult.success(pmsProductAttribute);
	}

	@ApiOperation("根据商品分类的id获取商品属性及属性分类")
	@RequestMapping("/attrInfo/{productCategoryId}")
	public CommonResult<List<ProductAttrInfo>> getAttrInfo(@PathVariable Long productCategoryId) {
		List<ProductAttrInfo> productAttrInfos = (List<ProductAttrInfo>) pmsProductAttributeService.getAttribute(productCategoryId);
		return CommonResult.success(productAttrInfos);
	}

}
