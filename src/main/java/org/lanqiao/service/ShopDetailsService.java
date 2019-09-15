package org.lanqiao.service;

import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;

import java.util.List;

public interface ShopDetailsService {
    Shop selectShopById(int shopId);

    List<Foodtype> selectFoodType(int shopId);

    List<Food> selectAllFood(int shopId);
}
