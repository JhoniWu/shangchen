package com.example.mymall.dto;

import com.example.mymall.mbg.model.PmsProduct;
import com.example.mymall.mbg.model.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-07-07 17:15
 **/
@Data
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {
	@ApiModelProperty("关联商品")
	private PmsProduct product;
}
