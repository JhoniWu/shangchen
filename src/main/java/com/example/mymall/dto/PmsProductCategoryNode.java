package com.example.mymall.dto;

import com.example.mymall.mbg.model.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @program: MyMall
 * @description: 包含子分类的商品分类
 * @author: Max Wu
 * @create: 2023-07-05 14:43
 **/
public class PmsProductCategoryNode extends PmsProductCategory {
	@ApiModelProperty("子分类集合")
	private List<PmsProductCategoryNode> children;
}
