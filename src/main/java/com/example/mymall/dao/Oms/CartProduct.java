package com.example.mymall.dao.Oms;

import com.example.mymall.mbg.model.PmsProductAttribute;
import com.example.mymall.mbg.model.PmsSkuStock;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: MyMall
 * @description: 购物车中带规格和SKU的商品信息
 * @author: Max Wu
 * @create: 2023-06-27 15:23
 **/
@Data
public class CartProduct {
	@ApiModelProperty("商品属性列表")
	private List<PmsProductAttribute> productAttributeList;
	@ApiModelProperty("商品SKU库存列表")
	private List<PmsSkuStock> skuStockList;
}
