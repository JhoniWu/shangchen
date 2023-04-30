package com.example.mymall.dto;

import com.example.mymall.mbg.model.PmsProductAttribute;
import com.example.mymall.mbg.model.PmsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: MyMall
 * @description: 带有属性的商品属性分类
 * @author: Max Wu
 * @create: 2023-04-30 21:03
 **/
@Getter
@Setter
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
	@ApiModelProperty(value = "商品属性列表")
	private List<PmsProductAttribute> productAttributeList;
}
