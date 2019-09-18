package org.lanqiao.service;

import org.lanqiao.entity.*;
import org.lanqiao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    OrdersMapper ordersMapper;

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
    public List<Food> selectFoodByFoodtype(int foodtypeId,String foodStatus,Integer foodStock) {

        return foodMapper.selectFoodByFoodtype(foodtypeId,foodStatus,foodStock);
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
        Food food = new Food();
        food.setFoodId(foodId);
        food.setFoodStatus("已删除");
        return foodMapper.updateByPrimaryKeySelective(food);
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

//    评价
    @Override
    public List<Comment> selectAllComment(int shopId,String comLevel) {
        List<Comment> commentList = new ArrayList<Comment>();
        commentList = commentMapper.selectAllComment(shopId,comLevel);
        for (Comment comment : commentList) {
            String str = "yyy-MM-dd HH:mm";
            SimpleDateFormat sdf = new SimpleDateFormat(str);
            String time=sdf.format(comment.getComTime());
            comment.setComTimeString(time);
        }
        return commentList;
    }

    @Override
    public int submitShopRsp(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment);
    }

    //    订单
    @Override
    public List<Orders> selectAllShopOrder(int shopId,String orderStatus) {
        List<Orders> orderList = new ArrayList<Orders>();
        orderList = ordersMapper.selectAllShopOrder(shopId,orderStatus);
        for (Orders order:orderList) {
            String str = "yyy-MM-dd HH:mm";
            SimpleDateFormat sdf = new SimpleDateFormat(str);
            String time=sdf.format(order.getOrderTime());
            order.setOrderTimeString(time);
        }
        return orderList;
    }

    @Override
    public List<Orders> selectTodayOrder(int shopId) {
        List<Orders> orderList = new ArrayList<Orders>();
        orderList = ordersMapper.selectTodayOrder(shopId);
        for (Orders order:orderList) {
            String str = "yyy-MM-dd HH:mm";
            SimpleDateFormat sdf = new SimpleDateFormat(str);
            String time=sdf.format(order.getOrderTime());
            order.setOrderTimeString(time);
        }
        return orderList;
    }


}
