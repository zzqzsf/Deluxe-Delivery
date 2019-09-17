package org.lanqiao.service;

import org.lanqiao.entity.Comment;
import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;
import org.lanqiao.mapper.CommentMapper;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopDetailsServiceImpl implements ShopDetailsService{
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    CommentMapper commentMapper;
    @Override
    public Shop selectShopById(Integer shopId) {
        return shopMapper.selectShopById(shopId);
    }

    @Override
    public List<Foodtype> selectFoodType(Integer shopId) {
        return shopMapper.selectFoodType(shopId);
    }

    @Override
    public List<Food> selectAllFood(Integer shopId, Integer foodTypeId) {
        return shopMapper.selectAllFood(shopId,foodTypeId);
    }

    @Override
    public List<Comment> SelectOpinion(Integer shopId, Integer level) {
        return commentMapper.SelectOpinion(shopId,level);
    }
}
