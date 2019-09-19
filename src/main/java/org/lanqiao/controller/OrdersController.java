package org.lanqiao.controller;


import org.lanqiao.entity.OrderItem;
import org.lanqiao.entity.OrderVo;
import org.lanqiao.entity.Orders;
import org.lanqiao.service.OrdersService;
import org.lanqiao.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
	@Autowired
	OrdersService ordersService;

	@RequestMapping("/upOrder")
	public int upOrder(Orders orders) {
		return ordersService.updateByPrimaryKey(orders);
	}

	@RequestMapping("/insertOrder")
	public int createOrder(@RequestBody OrderVo orderVo) {
		Orders orders = orderVo.getOrders();
		List<OrderItem> orderItems = orderVo.getOrderItems();
		return ordersService.createOrder(orderItems, orders);
	}

}

