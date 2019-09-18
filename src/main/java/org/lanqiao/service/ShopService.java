package org.lanqiao.service;

import org.lanqiao.entity.*;

import java.util.List;


public interface ShopService {

	public List<Shop> getShop(Integer shopId);
//    shop的
    public Shop selectShopInfo(int shopId);

    public int updateShopInfo(Shop shop);
//    food的
    public List<Food> selectFoodByFoodtype(int foodtypeId,String foodStatus,Integer foodStock);
    public int insertFood(Food food);
    public int updateFoodInfo(Food food);
    public int deleteFood(int foodId);
//foodtype的
    public List<Foodtype> selectFoodtypeList(int shopId);
    public int insertFoodtype(Foodtype foodtype);
    public int updateFoodtype(Foodtype foodtype);
    public int deleteFootype(int foodtypeId);
//Comment评价的
    public List<Comment> selectAllComment(int shopId,String comLevel);
    public int submitShopRsp(Comment comment);

//    order订单
//    全部订单
    public List<Orders> selectAllShopOrder(int shopId,String orderStatus);
    public List<Orders> selectTodayOrder(int shopId);
}
