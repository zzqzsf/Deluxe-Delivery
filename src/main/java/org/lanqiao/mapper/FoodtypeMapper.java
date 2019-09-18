package org.lanqiao.mapper;

import org.lanqiao.entity.Foodtype;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodtypeMapper {
	int deleteByPrimaryKey(Integer ftyId);


	int insertSelective(Foodtype record);


	int updateByPrimaryKeySelective(Foodtype record);
    List<Foodtype> selectFoodtypeList(int shopId);

}