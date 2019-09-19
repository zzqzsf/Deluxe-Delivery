package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Food;
import org.lanqiao.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


@Service
@Repository
public interface OrderItemMapper {
	int deleteByPrimaryKey(Integer detId);

	int insert(OrderItem orderItem);

	int insertSelective(OrderItem record);

	OrderItem selectByPrimaryKey(Integer detId);

	int updateByPrimaryKeySelective(OrderItem record);

	int updateByPrimaryKey(OrderItem record);

	List<Food> getFood(Integer foodId);

	List<OrderItem> selectOrderItemByOrderId(Integer orderId);

	Map getOrderDetail(@Param("orderId") Integer orderId);
}