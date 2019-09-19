package org.lanqiao.controller;


import org.lanqiao.entity.OrderItem;
import org.lanqiao.entity.OrderVo;
import org.lanqiao.entity.Orders;
import org.lanqiao.service.OrdersService;
import org.lanqiao.service.ShopService;
import org.lanqiao.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrdersController {
	@Autowired
	OrdersService ordersService;


    private static int ExpireTime = 9;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;


        @RequestMapping("getShopId1")
	public String getShopId1(String shopId){
        	redisUtil.set(shopId,0,ExpireTime);
        	return null;
	}

	@RequestMapping("/updateOrderState")
	public int updateOrderState(Integer orderId) {
		return ordersService.updateOrderState(orderId);
	}

	@RequestMapping("/insertOrder")
	public int createOrder(@RequestBody OrderVo orderVo) {
		Orders orders = orderVo.getOrders();
		List<OrderItem> orderItems = orderVo.getOrderItems();

			ordersService.createOrder(orderItems,orders);
			return orders.getOrderId();
	}

}

