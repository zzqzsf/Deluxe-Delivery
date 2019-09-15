package org.lanqiao.service;

import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;
import java.util.List;


public interface ShopService {
//    shop的
    public Shop selectShopInfo(int shopId);
    public int updateShopInfo(Shop shop);
//    food的
    public List<Food> selectFoodByFoodtype(int shopId);
    public int insertFood(Food food);
    public int updateFoodInfo(Food food);
    public int deleteFood(int foodId);
//foodtype的
    public List<Foodtype> selectFoodtypeList(int shopId);
    public int insertFoodtype(Foodtype foodtype);
    public int updateFoodtype(Foodtype foodtype);
    public int deleteFootype(int foodtypeId);
}
