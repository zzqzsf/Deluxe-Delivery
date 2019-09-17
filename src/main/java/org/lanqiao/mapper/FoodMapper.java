package org.lanqiao.mapper;

import org.lanqiao.entity.Food;
import org.lanqiao.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodMapper {
	int deleteByPrimaryKey(Integer foodId);


	int insertSelective(Food record);


	int updateByPrimaryKeySelective(Food record);

	List<Food> getFood(Integer foodId);

}