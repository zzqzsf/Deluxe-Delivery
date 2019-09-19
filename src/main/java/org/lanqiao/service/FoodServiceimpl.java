package org.lanqiao.service;

import org.lanqiao.entity.Food;
import org.lanqiao.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceimpl implements FoodService {
	@Autowired
	FoodMapper foodMapper;

	@Override
	public List<Food> getFood(Integer ftyId) {
		return foodMapper.getFood(ftyId);
	}

	@Override
	public int getFoodId(String foodName) {
		return foodMapper.getFoodId(foodName);
	}
}
