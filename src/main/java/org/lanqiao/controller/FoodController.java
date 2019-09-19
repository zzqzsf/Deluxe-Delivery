package org.lanqiao.controller;


import org.lanqiao.entity.Food;
import org.lanqiao.entity.Shop;
import org.lanqiao.service.FoodService;
import org.lanqiao.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
	@Autowired
	FoodService foodService;



	@RequestMapping("/getFood")
	public List<Food> getFood(Integer ftyId) {
		return foodService.getFood(ftyId);
	}
	@RequestMapping("/getFoodId")
	public int getFood(String foodName) {
		return foodService.getFoodId(foodName);
	}

}
