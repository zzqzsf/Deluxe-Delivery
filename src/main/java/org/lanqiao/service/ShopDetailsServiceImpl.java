package org.lanqiao.service;

import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopDetailsServiceImpl implements ShopDetailsService{
    @Autowired
    ShopMapper shopMapper;

    @Override
    public Shop selectShopById(int shopId) {
        return shopMapper.selectShopById(shopId);
    }

    @Override
    public List<Foodtype> selectFoodType(int shopId) {
        return shopMapper.selectFoodType(shopId);
    }

    @Override
    public List<Food> selectAllFood(int shopId) {
        return shopMapper.selectAllFood(shopId);
    }
}
