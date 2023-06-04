package com.example.mymall.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class WmsWareOrderTask implements Serializable {
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "order_id")
	private Long orderId;

	@ApiModelProperty(value = "order_sn")
	private String orderSn;

	@ApiModelProperty(value = "收货人")
	private String consignee;

	@ApiModelProperty(value = "收货人电话")
	private String consigneeTel;

	@ApiModelProperty(value = "配送地址")
	private String deliveryAddress;

	@ApiModelProperty(value = "订单备注")
	private String orderComment;

	@ApiModelProperty(value = "付款方式【 1:在线付款 2:货到付款】")
	private Boolean paymentWay;

	@ApiModelProperty(value = "任务状态")
	private Byte taskStatus;

	@ApiModelProperty(value = "订单描述")
	private String orderBody;

	@ApiModelProperty(value = "物流单号")
	private String trackingNo;

	@ApiModelProperty(value = "create_time")
	private Date createTime;

	@ApiModelProperty(value = "仓库id")
	private Long wareId;

	@ApiModelProperty(value = "工作单备注")
	private String taskComment;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeTel() {
		return consigneeTel;
	}

	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getOrderComment() {
		return orderComment;
	}

	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}

	public Boolean getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(Boolean paymentWay) {
		this.paymentWay = paymentWay;
	}

	public Byte getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Byte taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getOrderBody() {
		return orderBody;
	}

	public void setOrderBody(String orderBody) {
		this.orderBody = orderBody;
	}

	public String getTrackingNo() {
		return trackingNo;
	}

	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getWareId() {
		return wareId;
	}

	public void setWareId(Long wareId) {
		this.wareId = wareId;
	}

	public String getTaskComment() {
		return taskComment;
	}

	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", orderId=").append(orderId);
		sb.append(", orderSn=").append(orderSn);
		sb.append(", consignee=").append(consignee);
		sb.append(", consigneeTel=").append(consigneeTel);
		sb.append(", deliveryAddress=").append(deliveryAddress);
		sb.append(", orderComment=").append(orderComment);
		sb.append(", paymentWay=").append(paymentWay);
		sb.append(", taskStatus=").append(taskStatus);
		sb.append(", orderBody=").append(orderBody);
		sb.append(", trackingNo=").append(trackingNo);
		sb.append(", createTime=").append(createTime);
		sb.append(", wareId=").append(wareId);
		sb.append(", taskComment=").append(taskComment);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}