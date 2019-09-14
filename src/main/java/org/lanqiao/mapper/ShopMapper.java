package org.lanqiao.mapper;
import org.lanqiao.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShopMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insertSelective(Shop record);

    int updateByPrimaryKeySelective(Shop record);

    List<Shop>GetAllShops();
}