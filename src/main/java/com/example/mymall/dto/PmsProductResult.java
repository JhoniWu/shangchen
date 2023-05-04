package com.example.mymall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-05-01 14:03
 **/
public class PmsProductResult extends PmsProductParam {
	@Getter
	@Setter
	@ApiModelProperty("商品所选分类的父id")
	private Long cateParentId;
}
