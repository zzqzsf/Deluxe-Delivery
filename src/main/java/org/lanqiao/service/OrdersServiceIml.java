package org.lanqiao.service;

import org.lanqiao.entity.Orders;
import org.lanqiao.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceIml  implements OrdersService {

	@Autowired
	OrdersMapper ordersMapper;
	@Override
	public int insert(Orders orders) {
		return ordersMapper.insert(orders);
	}
}
