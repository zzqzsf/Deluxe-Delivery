package org.lanqiao.controller;

import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;
import org.lanqiao.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {
    @Autowired
    ShopService shopService;

    @RequestMapping("/selectShopInfo")
    public Shop selectShopInfo(int shopId){
        return shopService.selectShopInfo(shopId);
    }

    @RequestMapping("/updateShopInfo")
    public int updateShopInfo(Shop shop){
        return shopService.updateShopInfo(shop);
    }
//    food
    @RequestMapping("/selectFoodByFoodtype")
    public List<Food> selectFoodByFoodtype(int foodtypeId){
        return shopService.selectFoodByFoodtype(foodtypeId);
    }
    @RequestMapping("/insertFood")
    public int insertFood(Food food){
        return shopService.insertFood(food);
    }
    @RequestMapping("/updateFoodInfo")
    public int updateFoodInfo(Food food){
        return shopService.updateFoodInfo(food);
    }
    @RequestMapping("/deleteFood")
    public int deleteFood(int foodId){
        return shopService.deleteFood(foodId);
    }
//   foodtype
    @RequestMapping("/selectFoodtype")
    public List<Foodtype> selectFoodtype(int shopId){
        return shopService.selectFoodtypeList(shopId);
    }
    @RequestMapping("insertFoodtype")
    public int insertFoodtype(Foodtype foodtype){
        return shopService.insertFoodtype(foodtype);
    }
    @RequestMapping("deleteFoodtype")
    public int deleteFoodtype(int foodtypeId){
        return shopService.deleteFootype(foodtypeId);
    }
    @RequestMapping("updateFoodtype")
    public int updateFoodtype(Foodtype foodtype){
        return shopService.updateFoodtype(foodtype);
    }
//    订单
//    评价
}
