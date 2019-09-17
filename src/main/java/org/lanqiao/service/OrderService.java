package org.lanqiao.service;

import org.lanqiao.entity.Orders;
import org.lanqiao.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public List<Orders> getAllOrder(int pageNum, int pageSize);
}
