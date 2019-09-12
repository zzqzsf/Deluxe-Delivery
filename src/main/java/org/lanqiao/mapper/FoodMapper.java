package org.lanqiao.mapper;

import org.lanqiao.entity.Food;

public interface FoodMapper {
    int deleteByPrimaryKey(Integer foodId);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(Integer foodId);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}