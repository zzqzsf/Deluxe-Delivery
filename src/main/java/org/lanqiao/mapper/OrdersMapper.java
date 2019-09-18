package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Orders;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

@Service
@Component
public interface OrdersMapper {
	int deleteByPrimaryKey(Integer orderId);

	int insert(Orders orders);

	int insertSelective(Orders record);

	Orders selectByPrimaryKey(Integer orderId);

	int updateByPrimaryKeySelective(Orders record);

	int updateByPrimaryKey(Orders record);

	List<Orders> getOrderList( @Param("customerId") int customerId);


    List<Orders> selectAllShopOrder(int shopId,String orderStatus);
    List<Orders> selectTodayOrder(int shopId);
}