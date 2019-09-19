package org.lanqiao.service;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Location;
import org.lanqiao.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShopShowService {
    List<Shop> GetAllShops(List<Location> locationList);
    int getShopId(String shopName);
}
