package org.lanqiao.mapper;

import org.lanqiao.entity.Shop;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer shopId);



    int insertSelective(Shop record);



    int updateByPrimaryKeySelective(Shop record);


}