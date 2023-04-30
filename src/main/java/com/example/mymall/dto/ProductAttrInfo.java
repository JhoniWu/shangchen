package com.example.mymall.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program: MyMall
 * @description: 商品分类对应属性信息
 * @author: Max Wu
 * @create: 2023-04-30 21:33
 **/
public class ProductAttrInfo {
	@ApiModelProperty("商品属性ID")
	private Long attributeId;
	@ApiModelProperty("商品属性分类ID")
	private Long attributeCategoryId;
}
