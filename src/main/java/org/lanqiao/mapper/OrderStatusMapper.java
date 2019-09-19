package org.lanqiao.mapper;

import org.lanqiao.entity.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OrderStatusMapper {

    List<OrderStatus> getOrderStatus(int orderId);

    int insert(OrderStatus record);

    int insertSelective(OrderStatus record);
}