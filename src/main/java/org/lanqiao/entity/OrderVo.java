package org.lanqiao.entity;

import java.util.List;

public class OrderVo {
	private Orders orders;
	private List<OrderItem> orderItems;

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders order) {
		this.orders = order;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
