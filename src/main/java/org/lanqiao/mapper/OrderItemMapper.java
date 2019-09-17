package org.lanqiao.mapper;

import org.lanqiao.entity.Food;
import org.lanqiao.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
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
}