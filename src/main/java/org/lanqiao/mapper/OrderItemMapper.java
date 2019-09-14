package org.lanqiao.mapper;

import org.lanqiao.entity.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer detId);



    int insertSelective(OrderItem record);



    int updateByPrimaryKeySelective(OrderItem record);


}