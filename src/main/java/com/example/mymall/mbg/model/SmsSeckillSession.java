package com.example.mymall.mbg.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SmsSeckillSession implements Serializable {
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "场次名称")
	private String name;

	@ApiModelProperty(value = "每日开始时间")
	private Date startTime;

	@ApiModelProperty(value = "每日结束时间")
	private Date endTime;

	@ApiModelProperty(value = "启用状态")
	private Boolean status;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@TableField(exist = false)
	private List<SmsSeckillSkuRelation> relationSkus;

	public List<SmsSeckillSkuRelation> getRelationSkus() {
		return relationSkus;
	}

	public void setRelationSkus(List<SmsSeckillSkuRelation> relationSkus) {
		this.relationSkus = relationSkus;
	}

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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", name=").append(name);
		sb.append(", startTime=").append(startTime);
		sb.append(", endTime=").append(endTime);
		sb.append(", status=").append(status);
		sb.append(", createTime=").append(createTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}