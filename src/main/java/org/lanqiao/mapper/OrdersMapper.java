package org.lanqiao.mapper;

import org.lanqiao.entity.Orders;
import org.springframework.stereotype.Service;


@Service
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders orders);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}