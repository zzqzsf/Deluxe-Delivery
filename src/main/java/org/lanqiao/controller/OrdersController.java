package org.lanqiao.controller;


import org.lanqiao.entity.Orders;
import org.lanqiao.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	@RequestMapping("/insertOrders")
	public int insertOrders(Orders orders){
		return ordersService.insert(orders);
	}
}
