package org.lanqiao.service;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Collections;
import org.lanqiao.entity.Location;
import org.lanqiao.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShopShowService {
//    List<Shop> GetAllShops(List<Location> locationList);
    List<Shop> GetAllShops();
    public int selects(int cusId,int shopId );

    int getShopId(String shopName);
    public int delate(int cusId,int shopId);
}
