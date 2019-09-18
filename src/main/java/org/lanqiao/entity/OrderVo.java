package org.lanqiao.entity;

import java.util.List;

public class OrderVo {
	private Orders order;
	private List<OrderItem> orderItems;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
