package com.example.mymall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class WmsWareInfo implements Serializable {
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "仓库名")
	private String name;

	@ApiModelProperty(value = "仓库地址")
	private String address;

	@ApiModelProperty(value = "区域编码")
	private String areacode;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", address=").append(address);
		sb.append(", areacode=").append(areacode);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}