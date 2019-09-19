package org.lanqiao.mapper;

import org.lanqiao.entity.OrderStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;

import java.util.List;
@Repository
@Component
public interface OrderStatusMapper {
	int insert(OrderStatus record);
	int insertSelective(OrderStatus record);
	List<OrderStatus> selectOrderStatus(int orderId);

    List<OrderStatus> getOrderStatus(int orderId);

}