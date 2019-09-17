package org.lanqiao.controller;

import org.lanqiao.entity.Comment;
import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;
import org.lanqiao.service.ShopDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopDetailsController {
    @Autowired
    ShopDetailsService shopDetailsService;

    @RequestMapping("/shop")
    public Shop selectShopById(Integer shopId) {
        return shopDetailsService.selectShopById(shopId);
    }
    @RequestMapping("/foodType")
    public List<Foodtype> selectFoodType(Integer shopId) {
        return shopDetailsService.selectFoodType(shopId);
    }

    @RequestMapping("/food")
    public List<Food> selectAllFood(Integer shopId, Integer foodTypeId) {
        return shopDetailsService.selectAllFood(shopId,foodTypeId);
    }
    @RequestMapping("/comment")
    public List<Comment> SelectOpinion() {
        return shopDetailsService.SelectOpinion(1,-1);
    }
}
