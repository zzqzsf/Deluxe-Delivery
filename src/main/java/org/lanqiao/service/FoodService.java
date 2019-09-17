package org.lanqiao.service;


import org.lanqiao.entity.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
	public List<Food> getFood(Integer ftyId);
}
