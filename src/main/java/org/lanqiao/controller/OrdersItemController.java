package org.lanqiao.controller;


import org.lanqiao.entity.OrderItem;
import org.lanqiao.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersItemController {
	@Autowired
	OrderItemService orderItemService;

	@RequestMapping("/test")
	public boolean test(){
		return true;
	}

}
