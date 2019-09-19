package org.lanqiao.service;

import org.lanqiao.entity.Collections;
import org.lanqiao.entity.Comment;
import org.lanqiao.entity.OrderStatus;
import org.lanqiao.entity.Orders;
import org.lanqiao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    OrderStatusMapper orderStatusMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    CustomMapper customMapper;
    @Autowired
    CollectionMapper collectionMapper;

    public List<Orders> getAllOrder(int pageNum, int pageSize, Integer customerId) {

//        return ordersMapper.getAllOrder((pageNum)*pageSize,pageSize,customerId);
        return ordersMapper.getOrderList(customerId);
    }

    @Override
    public List<OrderStatus> getOrderStatus(Integer orderId) {

        return orderStatusMapper.getOrderStatus(orderId);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public Map getOrderDetail(Integer orderId) {
        return orderItemMapper.getOrderDetail(orderId);
    }

    @Override
    public Map getUserInfo(Integer customerId) {
        return customMapper.getUserInfo(customerId);
    }

    @Override
    public List<Collections> getCollectionShop(Integer customerId) {
        return collectionMapper.getCollectionShop(customerId);
    }
}
