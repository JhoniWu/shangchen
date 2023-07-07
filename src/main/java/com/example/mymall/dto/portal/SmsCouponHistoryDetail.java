package com.example.mymall.dto.portal;

import com.example.mymall.mbg.model.SmsCoupon;
import com.example.mymall.mbg.model.SmsCouponHistory;
import com.example.mymall.mbg.model.SmsCouponProductCategoryRelation;
import com.example.mymall.mbg.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: MyMall
 * @description: 优惠券领取历史详情
 * @author: Max Wu
 * @create: 2023-07-05 15:14
 **/
@Data
public class SmsCouponHistoryDetail extends SmsCouponHistory {
	@ApiModelProperty("相关优惠券信息")
	private SmsCoupon coupon;
	@ApiModelProperty("优惠券关联商品")
	private List<SmsCouponProductRelation> productRelationList;
	@ApiModelProperty("优惠券关联商品分类")
	private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}
