package org.lanqiao.service;

import org.lanqiao.entity.Orders;
import org.lanqiao.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl  implements OrderService{
    @Autowired
    OrdersMapper ordersMapper;

    public List<Orders> getAllOrder(int pageNum, int pageSize){
        return ordersMapper.getAllOrder((pageNum-1)*pageSize,pageSize);
    }
}
