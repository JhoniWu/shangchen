package com.example.mymall.dto;

import com.example.mymall.mbg.model.PmsProduct;
import com.example.mymall.mbg.model.PmsProductFullReduction;
import com.example.mymall.mbg.model.PmsProductLadder;
import com.example.mymall.mbg.model.PmsSkuStock;
import lombok.Data;

import java.util.List;

/**
 * @program: MyMall
 * @description: 促销商品信息，包括sku、打折优惠、满减优惠
 * @author: Max Wu
 * @create: 2023-06-28 00:09
 **/
@Data
public class PromotionProduct extends PmsProduct {
	//商品库存信息
	private List<PmsSkuStock> skuStockList;
	//商品打折信息
	private List<PmsProductLadder> productLadderList;
	//商品满减信息
	private List<PmsProductFullReduction> productFullReductionList;
}
