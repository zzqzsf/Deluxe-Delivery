package org.lanqiao.mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Location;
import org.lanqiao.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopMapper {
	int deleteByPrimaryKey(Integer shopId);
	int insertSelective(Shop record);
	int updateByPrimaryKeySelective(Shop record);

    List<Shop> GetAllShops(List<Location> locationList);
	List<Shop> GetAllShops();

	List<Shop> getShop(Integer shopId);
//    商家版--查店铺信息
    Shop SelectShopInfo(Integer shopId);
//    更改店铺状态
    int updateShopStatus(String shopState,int shopId);

    //店铺详情页面所需接口
    Shop selectShopById(Integer shopId);
    List<Foodtype> selectFoodType(Integer shopId);
    List<Food> selectAllFood(Integer shopId,Integer foodTypeId);
}