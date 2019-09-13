package org.lanqiao.mapper;

import org.lanqiao.entity.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer detId);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer detId);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}