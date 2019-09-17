package org.lanqiao.mapper;

import org.lanqiao.entity.Foodtype;

public interface FoodtypeMapper {
	int deleteByPrimaryKey(Integer ftyId);


	int insertSelective(Foodtype record);


	int updateByPrimaryKeySelective(Foodtype record);


}