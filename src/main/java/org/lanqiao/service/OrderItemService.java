package org.lanqiao.service;

import org.lanqiao.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface OrderItemService {
    public int insert(OrderItem orderItem);



}
