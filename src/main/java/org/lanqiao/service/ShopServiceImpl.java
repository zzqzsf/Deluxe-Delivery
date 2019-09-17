package org.lanqiao.service;

import org.lanqiao.entity.Comment;
import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;
import org.lanqiao.mapper.CommentMapper;
import org.lanqiao.mapper.FoodMapper;
import org.lanqiao.mapper.FoodtypeMapper;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopMapper shopMapper;

    @Autowired
    FoodMapper foodMapper;

    @Autowired
    FoodtypeMapper foodtypeMapper;
    @Autowired
    CommentMapper commentMapper;
    @Override
    public Shop selectShopInfo(int shopId) {
        return shopMapper.SelectShopInfo(shopId);
    }

    @Override
    public int updateShopInfo(Shop shop) {
        return shopMapper.updateByPrimaryKeySelective(shop);
    }
//    food 部分
    @Override
    public List<Food> selectFoodByFoodtype(int foodtypeId) {

        return foodMapper.selectFoodByFoodtype(foodtypeId);
    }

    @Override
    public int insertFood(Food food) {
        return foodMapper.insertSelective(food);
    }

    @Override
    public int updateFoodInfo(Food food) {
        return foodMapper.updateByPrimaryKeySelective(food);
    }

    @Override
    public int deleteFood(int foodId) {
        return foodMapper.deleteByPrimaryKey(foodId);
    }
//    foodtype部分
    @Override
    public List<Foodtype> selectFoodtypeList(int shopId) {
        return foodtypeMapper.selectFoodtypeList(shopId);
    }

    @Override
    public int insertFoodtype(Foodtype foodtype) {
        return foodtypeMapper.insertSelective(foodtype);
    }

    @Override
    public int updateFoodtype(Foodtype foodtype) {
        return foodtypeMapper.updateByPrimaryKeySelective(foodtype);
    }

    @Override
    public int deleteFootype(int foodtypeId) {
        return foodtypeMapper.deleteByPrimaryKey(foodtypeId);
    }

    @Override
    public List<Comment> selectAllComment(int shopId) {
        return commentMapper.selectAllComment(shopId);
    }


}
