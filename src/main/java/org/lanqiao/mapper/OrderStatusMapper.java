package org.lanqiao.mapper;

import org.lanqiao.entity.OrderStatus;

public interface OrderStatusMapper {
    int insert(OrderStatus record);

	int insertSelective(OrderStatus record);
}