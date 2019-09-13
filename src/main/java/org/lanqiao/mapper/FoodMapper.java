package org.lanqiao.mapper;

import org.lanqiao.entity.Food;

public interface FoodMapper {
    int deleteByPrimaryKey(Integer foodId);



    int insertSelective(Food record);



    int updateByPrimaryKeySelective(Food record);


}