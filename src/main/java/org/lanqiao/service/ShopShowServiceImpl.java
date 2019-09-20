package org.lanqiao.service;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Collections;
import org.lanqiao.entity.Location;
import org.lanqiao.entity.Shop;
import org.lanqiao.mapper.CollectionMapper;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShopShowServiceImpl  implements ShopShowService{
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    CollectionMapper collectionMapper;
//    @Override
//    public List<Shop> GetAllShops(List<Location> locationList) {
//        return shopMapper.GetAllShops(locationList);
//
//    }
    @Override
    public List<Shop> GetAllShops() {
        return shopMapper.GetAllShops();

    }

    @Override
    public int selects(int cusId,int shopId) {
        return collectionMapper.insertSelective(cusId,shopId);
    }
    public int delate(int cusId,int shopId){
        return collectionMapper.delate(cusId,shopId);
    }
    public int getShopId(String shopName){
        return shopMapper.getShopId(shopName);
    }
}
