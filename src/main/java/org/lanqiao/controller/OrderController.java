package org.lanqiao.controller;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Collections;
import org.lanqiao.entity.Comment;
import org.lanqiao.entity.OrderStatus;
import org.lanqiao.entity.Orders;
import org.lanqiao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


    @RequestMapping("/getAllOrder")
    public List<Orders> getAllOrder(int pageNum, int pageSize, Integer customerId) {
        return orderService.getAllOrder(pageNum, pageSize, customerId);
    }

    @RequestMapping("/getOrderDetail")
    public Map getOrderDetail(Integer orderId) {
        return orderService.getOrderDetail(orderId);
    }

    @RequestMapping("/getOrderStatus")
    public List<OrderStatus> getOrderStatus(Integer orderId) {
        return orderService.getOrderStatus(orderId);
    }

    @RequestMapping("/insertComment")
    public int insertComment(Comment comment) {
        return orderService.insertComment(comment);
    }

    @RequestMapping("/getUserInfo")
    public Map getUserInfo(Integer customerId) {
        return orderService.getUserInfo(customerId);
    }

    @RequestMapping("/getCollectionShop")
    public List<Collections> getCollectionShop(Integer customerId) {
        return orderService.getCollectionShop(customerId);
    }


}
