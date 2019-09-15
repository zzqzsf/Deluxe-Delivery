package org.lanqiao.controller;

import org.lanqiao.entity.Orders;
import org.lanqiao.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/getAllOrder")
    public List<Orders> getAllOrder(int pageNum, int pageSize) {
        return orderService.getAllOrder(pageNum,pageSize);

    }
}
