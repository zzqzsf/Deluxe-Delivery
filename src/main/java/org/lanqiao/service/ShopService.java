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
//    预计订单
    public List<Orders> selectExpectOrder(int shopId);
//    修改订单状态，同时往订单状态表插一条数据
    public void updateOrderStatus(Orders orders);
//    查询订单详情
    public List<OrderItem> selectOrderItemByOrderId(int orderId);
//    查询订单状态
    public List<OrderStatus> selectOrderStatus(int orderId);
    public List<Comment> selectAllComment(int shopId);
    //检查商铺手机是否被注册
     public String checkShopName(String shopName);

     public  int insertShop(Shop shop);

     public int checkShopTel(String shopTel);
     public int checkShopPass(String cusTel,String cusName);
}
