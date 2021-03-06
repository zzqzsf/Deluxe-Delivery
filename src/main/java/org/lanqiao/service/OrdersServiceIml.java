package org.lanqiao.service;

import org.lanqiao.entity.OrderItem;
import org.lanqiao.entity.Orders;
import org.lanqiao.mapper.OrderItemMapper;
import org.lanqiao.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersServiceIml implements OrdersService {

	@Autowired
	OrdersMapper ordersMapper;
	@Autowired
	OrderItemMapper orderItemMapper;

	@Override
	public int updateByPrimaryKey(Orders record)
 {
		return ordersMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateOrderState(Integer orderId) {
		return ordersMapper.updateOrderState(orderId);
	}


	@Override
	public int createOrder(List<OrderItem> orderItems, Orders orders) {
		ordersMapper.insertSelective(orders);//获得orderId
		for (OrderItem oi : orderItems) {
			oi.setOrderId(orders.getOrderId());
			orderItemMapper.insert(oi);
		}

		return orders.getOrderId();
	}

}
