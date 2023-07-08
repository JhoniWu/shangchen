package com.example.mymall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class SmsSeckillSkuRelation implements Serializable {
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "活动id")
	private Long promotionId;

	@ApiModelProperty(value = "活动场次id")
	private Long promotionSessionId;

	@ApiModelProperty(value = "商品id")
	private Long skuId;

	@ApiModelProperty(value = "秒杀价格")
	private BigDecimal seckillPrice;

	@ApiModelProperty(value = "秒杀总量")
	private Integer seckillCount;

	@ApiModelProperty(value = "每人限购数量")
	private Integer seckillLimit;

	@ApiModelProperty(value = "排序")
	private Integer seckillSort;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	public Long getPromotionSessionId() {
		return promotionSessionId;
	}

	public void setPromotionSessionId(Long promotionSessionId) {
		this.promotionSessionId = promotionSessionId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public BigDecimal getSeckillPrice() {
		return seckillPrice;
	}

	public void setSeckillPrice(BigDecimal seckillPrice) {
		this.seckillPrice = seckillPrice;
	}

	public Integer getSeckillCount() {
		return seckillCount;
	}

	public void setSeckillCount(Integer seckillCount) {
		this.seckillCount = seckillCount;
	}

	public Integer getSeckillLimit() {
		return seckillLimit;
	}

	public void setSeckillLimit(Integer seckillLimit) {
		this.seckillLimit = seckillLimit;
	}

	public Integer getSeckillSort() {
		return seckillSort;
	}

	public void setSeckillSort(Integer seckillSort) {
		this.seckillSort = seckillSort;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", promotionId=").append(promotionId);
		sb.append(", promotionSessionId=").append(promotionSessionId);
		sb.append(", skuId=").append(skuId);
		sb.append(", seckillPrice=").append(seckillPrice);
		sb.append(", seckillCount=").append(seckillCount);
		sb.append(", seckillLimit=").append(seckillLimit);
		sb.append(", seckillSort=").append(seckillSort);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}