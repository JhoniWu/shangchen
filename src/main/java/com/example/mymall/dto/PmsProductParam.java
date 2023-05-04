package com.example.mymall.dto;

import com.example.mymall.mbg.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-05-01 13:43
 **/

@Data
@EqualsAndHashCode
public class PmsProductParam extends PmsProduct {
	@ApiModelProperty("商品阶梯价格设置")
	private List<PmsProductLadder> productLadderList;
	@ApiModelProperty("商品满减价格设置")
	private List<PmsProductFullReduction> productFullReductionList;
	@ApiModelProperty("商品会员价格设置")
	private List<PmsMemberPrice> memberPriceList;
	@ApiModelProperty("商品的sku库存信息")
	private List<PmsSkuStock> skuStockList;
	@ApiModelProperty("商品参数及自定义规格属性")
	private List<PmsProductAttributeValue> productAttributeValueList;
	@ApiModelProperty("专题和商品关系")
	private List<CmsSubjectProductRelation> subjectProductRelationList;
	@ApiModelProperty("优选专区和商品的关系")
	private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;
}
