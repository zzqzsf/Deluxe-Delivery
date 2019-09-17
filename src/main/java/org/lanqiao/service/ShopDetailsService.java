package org.lanqiao.service;

import org.lanqiao.entity.Comment;
import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;

import java.util.List;

public interface ShopDetailsService {
    Shop selectShopById(Integer shopId);

    List<Foodtype> selectFoodType(Integer shopId);

    List<Food> selectAllFood(Integer shopId, Integer foodTypeId);

    List<Comment> SelectOpinion(Integer shopId, Integer level);
}
