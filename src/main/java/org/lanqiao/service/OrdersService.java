package org.lanqiao.service;

import org.lanqiao.entity.Orders;
import org.springframework.stereotype.Service;

@Service
public interface OrdersService {

	public  int insert(Orders orders);
}
