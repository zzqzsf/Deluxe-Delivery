package org.lanqiao.mapper;

import org.lanqiao.entity.Foodtype;

public interface FoodtypeMapper {
    int deleteByPrimaryKey(Integer ftyId);

    int insert(Foodtype record);

    int insertSelective(Foodtype record);

    Foodtype selectByPrimaryKey(Integer ftyId);

    int updateByPrimaryKeySelective(Foodtype record);

    int updateByPrimaryKey(Foodtype record);
}