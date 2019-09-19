package org.lanqiao.service;

import org.lanqiao.entity.Comment;
import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;
import java.util.List;


public interface ShopService {
//	public List<Shop> selectShopInfo(int shopId);

	public List<Shop> getShop(Integer shopId);
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
//Comment评价的
    public List<Comment> selectAllComment(int shopId);
    //检查商铺手机是否被注册
     public String checkShopName(String shopName);

     public  int insertShop(Shop shop);
}
