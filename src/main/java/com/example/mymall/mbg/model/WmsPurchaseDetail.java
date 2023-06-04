package com.example.mymall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class WmsPurchaseDetail implements Serializable {
	private Long id;

	@ApiModelProperty(value = "采购单id")
	private Long purchaseId;

	@ApiModelProperty(value = "采购商品id")
	private Long skuId;

	@ApiModelProperty(value = "采购数量")
	private Integer skuNum;

	@ApiModelProperty(value = "采购金额")
	private BigDecimal skuPrice;

	@ApiModelProperty(value = "仓库id")
	private Long wareId;

	@ApiModelProperty(value = "状态[0新建，1已分配，2正在采购，3已完成，4采购失败]")
	private Integer status;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Integer getSkuNum() {
		return skuNum;
	}

	public void setSkuNum(Integer skuNum) {
		this.skuNum = skuNum;
	}

	public BigDecimal getSkuPrice() {
		return skuPrice;
	}

	public void setSkuPrice(BigDecimal skuPrice) {
		this.skuPrice = skuPrice;
	}

	public Long getWareId() {
		return wareId;
	}

	public void setWareId(Long wareId) {
		this.wareId = wareId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", purchaseId=").append(purchaseId);
		sb.append(", skuId=").append(skuId);
		sb.append(", skuNum=").append(skuNum);
		sb.append(", skuPrice=").append(skuPrice);
		sb.append(", wareId=").append(wareId);
		sb.append(", status=").append(status);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}