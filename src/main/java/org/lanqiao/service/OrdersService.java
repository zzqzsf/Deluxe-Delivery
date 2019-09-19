package org.lanqiao.service;

import org.lanqiao.entity.OrderItem;
import org.lanqiao.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {

//	public int insert(Orders orders);

	public int createOrder(List<OrderItem> orderItems, Orders orders);

	public int updateByPrimaryKey(Orders record);

	public int updateOrderState(Integer orderId);
}
