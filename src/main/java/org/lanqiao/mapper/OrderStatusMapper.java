package org.lanqiao.mapper;

import org.lanqiao.entity.OrderStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusMapper {


    int insertSelective(OrderStatus record);
}