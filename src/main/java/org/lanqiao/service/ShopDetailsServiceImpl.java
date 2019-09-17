package org.lanqiao.service;

import org.lanqiao.entity.*;
import org.lanqiao.mapper.CommentMapper;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Comment> comList = new ArrayList<>();
        try{
            comList = commentMapper.SelectOpinion(shopId,level);
            for (Comment com:comList) {
                String hide = nameHide(com.getCustom().getCusName());
                com.getCustom().setCusName(hide);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return comList;
    }
    //顾客名匿名评论
    private String nameHide(String cusName){
        String str = "";
        try {
            str = cusName.substring(0,1) + "**" + cusName.substring(cusName.length()-1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
