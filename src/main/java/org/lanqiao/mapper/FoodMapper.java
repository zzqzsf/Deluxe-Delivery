package org.lanqiao.mapper;

import org.lanqiao.entity.Food;
import org.lanqiao.entity.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodMapper {
    int deleteByPrimaryKey(Integer foodId);
    int insertSelective(Food record);
    int updateByPrimaryKeySelective(Food record);
// 根据分类查商品
    List<Food> selectFoodByFoodtype(Integer foodtypeId,String foodStatus,Integer foodStock);
	List<Food> getFood(Integer ftyId);

}