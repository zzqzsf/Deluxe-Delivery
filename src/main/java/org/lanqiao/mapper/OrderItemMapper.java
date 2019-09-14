package org.lanqiao.mapper;

import org.lanqiao.entity.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer detId);



    int insertSelective(OrderItem record);



    int updateByPrimaryKeySelective(OrderItem record);


}