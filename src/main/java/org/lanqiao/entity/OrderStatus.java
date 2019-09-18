package org.lanqiao.entity;

import java.util.Date;

public class OrderStatus {
	private Integer orderId;

	private String orderStatus;

	private Date orderStatusUpdateTime;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus == null ? null : orderStatus.trim();
	}

	public Date getOrderStatusUpdateTime() {
		return orderStatusUpdateTime;
	}

	public void setOrderStatusUpdateTime(Date orderStatusUpdateTime) {
		this.orderStatusUpdateTime = orderStatusUpdateTime;
	}
}