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

	@RequestMapping("/insertOrders")
	public int insertOrders(Orders orders) {
		return ordersService.insert(orders);
	}

	@RequestMapping("/insertOrder")
	public int createOrder(@RequestBody OrderVo orderVo) {
		Orders order = orderVo.getOrder();
		List<OrderItem> orderItems = orderVo.getOrderItems();
		return ordersService.createOrder(orderItems, order);
	}

}

