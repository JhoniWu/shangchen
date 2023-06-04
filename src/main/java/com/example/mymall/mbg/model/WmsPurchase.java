package com.example.mymall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WmsPurchase implements Serializable {
	@ApiModelProperty(value = "采购单id")
	private Long id;

	@ApiModelProperty(value = "采购人id")
	private Long assigneeId;

	@ApiModelProperty(value = "采购人名")
	private String assigneeName;

	@ApiModelProperty(value = "联系方式")
	private String phone;

	@ApiModelProperty(value = "优先级")
	private Integer priority;

	@ApiModelProperty(value = "状态")
	private Integer status;

	@ApiModelProperty(value = "仓库id")
	private Long wareId;

	@ApiModelProperty(value = "总金额")
	private BigDecimal amount;

	@ApiModelProperty(value = "创建日期")
	private Date createTime;

	@ApiModelProperty(value = "更新日期")
	private Date updateTime;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public String getAssigneeName() {
		return assigneeName;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getWareId() {
		return wareId;
	}

	public void setWareId(Long wareId) {
		this.wareId = wareId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", assigneeId=").append(assigneeId);
		sb.append(", assigneeName=").append(assigneeName);
		sb.append(", phone=").append(phone);
		sb.append(", priority=").append(priority);
		sb.append(", status=").append(status);
		sb.append(", wareId=").append(wareId);
		sb.append(", amount=").append(amount);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}