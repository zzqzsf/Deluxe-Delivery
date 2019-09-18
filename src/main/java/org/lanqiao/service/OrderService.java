package org.lanqiao.service;

import org.lanqiao.entity.Comment;
import org.lanqiao.entity.OrderStatus;
import org.lanqiao.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderService {

    public List<Orders> getAllOrder(int pageNum, int pageSize, Integer customerId);

    public List<OrderStatus> getOrderStatus(Integer orderId);

    public int insertComment(Comment comment);

    public Map getOrderDetail(Integer orderId);
}
