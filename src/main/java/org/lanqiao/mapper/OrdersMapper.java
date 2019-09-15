package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Orders;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderId);
    int insertSelective(Orders record);
    int updateByPrimaryKeySelective(Orders record);

    List<Orders> getAllOrder(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize );
}