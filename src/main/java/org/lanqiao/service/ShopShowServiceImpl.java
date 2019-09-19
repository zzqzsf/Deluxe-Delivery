package org.lanqiao.service;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Location;
import org.lanqiao.entity.Shop;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShopShowServiceImpl  implements ShopShowService{
    @Autowired
    ShopMapper shopMapper;
    @Override
    public List<Shop> GetAllShops(List<Location> locationList) {
        return shopMapper.GetAllShops(locationList);
    }

    public int getShopId(String shopName){
        return shopMapper.getShopId(shopName);
    }
}
