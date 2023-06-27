package com.example.mymall.dto.Cart;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-26 15:22
 **/
@Data
public class CartItem {
	private Long skuId;
	private Boolean check = true;
	private String title;
	private String image;
	private List<String> attr;
	private BigDecimal price;
	private Integer count;
	private BigDecimal totalPrice;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getAttr() {
		return attr;
	}

	public void setAttr(List<String> attr) {
		this.attr = attr;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BigDecimal getTotalPrice() {
		BigDecimal multiply = this.price.multiply(new BigDecimal("" + this.count));
		return multiply;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
