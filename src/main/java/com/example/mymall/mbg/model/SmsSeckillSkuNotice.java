package com.example.mymall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SmsSeckillSkuNotice implements Serializable {
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "member_id")
	private Long memberId;

	@ApiModelProperty(value = "sku_id")
	private Long skuId;

	@ApiModelProperty(value = "活动场次id")
	private Long sessionId;

	@ApiModelProperty(value = "订阅时间")
	private Date subcribeTime;

	@ApiModelProperty(value = "发送时间")
	private Date sendTime;

	@ApiModelProperty(value = "通知方式[0-短信，1-邮件]")
	private Boolean noticeType;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Date getSubcribeTime() {
		return subcribeTime;
	}

	public void setSubcribeTime(Date subcribeTime) {
		this.subcribeTime = subcribeTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Boolean getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Boolean noticeType) {
		this.noticeType = noticeType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", memberId=").append(memberId);
		sb.append(", skuId=").append(skuId);
		sb.append(", sessionId=").append(sessionId);
		sb.append(", subcribeTime=").append(subcribeTime);
		sb.append(", sendTime=").append(sendTime);
		sb.append(", noticeType=").append(noticeType);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}