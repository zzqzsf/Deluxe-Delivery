package org.lanqiao.mapper;

import org.lanqiao.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FoodMapper {
    int deleteByPrimaryKey(Integer foodId);
    int insertSelective(Food record);
    int updateByPrimaryKeySelective(Food record);
// 根据分类查商品
    List<Food> selectFoodByFoodtype(Integer foodtypeId);


}