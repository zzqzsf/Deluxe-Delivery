package org.lanqiao.controller;

import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;
import org.lanqiao.service.ShopDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopDetailsController {
    @Autowired
    ShopDetailsService shopDetailsService;
    @RequestMapping("/shop")
    public Shop selectShopById() {
        return shopDetailsService.selectShopById(1);
    }
    @RequestMapping("/foodType")
    public List<Foodtype> selectFoodType() {
        return shopDetailsService.selectFoodType(1);
    }
    @RequestMapping("/food")
    public List<Food> selectAllFood() {
        return shopDetailsService.selectAllFood(1);
    }
}
