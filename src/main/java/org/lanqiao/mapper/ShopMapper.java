package org.lanqiao.mapper;
import org.lanqiao.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShopMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer shopId);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    List<Shop>GetAllShops();
}