package org.lanqiao.mapper;

import org.lanqiao.entity.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderId);



    int insertSelective(Orders record);



    int updateByPrimaryKeySelective(Orders record);


}