package com.example.mymall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class WmsWareSku implements Serializable {
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "sku_id")
	private Long skuId;

	@ApiModelProperty(value = "仓库id")
	private Long wareId;

	@ApiModelProperty(value = "库存数")
	private Integer stock;

	@ApiModelProperty(value = "sku_name")
	private String skuName;

	@ApiModelProperty(value = "锁定库存")
	private Integer stockLocked;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getWareId() {
		return wareId;
	}

	public void setWareId(Long wareId) {
		this.wareId = wareId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public Integer getStockLocked() {
		return stockLocked;
	}

	public void setStockLocked(Integer stockLocked) {
		this.stockLocked = stockLocked;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", skuId=").append(skuId);
		sb.append(", wareId=").append(wareId);
		sb.append(", stock=").append(stock);
		sb.append(", skuName=").append(skuName);
		sb.append(", stockLocked=").append(stockLocked);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}