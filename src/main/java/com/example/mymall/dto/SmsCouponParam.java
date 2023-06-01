package com.example.mymall.dto;

import com.example.mymall.mbg.model.SmsCoupon;
import com.example.mymall.mbg.model.SmsCouponProductCategoryRelation;
import com.example.mymall.mbg.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-01 16:13
 **/
@Data
public class SmsCouponParam extends SmsCoupon {
	@Getter
	@Setter
	@ApiModelProperty("优惠券绑定的商品")
	private List<SmsCouponProductRelation> productRelationList;
	@Getter
	@Setter
	@ApiModelProperty("优惠券绑定的商品分类")
	private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}
