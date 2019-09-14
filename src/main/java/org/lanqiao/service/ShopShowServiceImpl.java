package org.lanqiao.service;

import org.lanqiao.entity.Shop;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopShowServiceImpl  implements ShopShowService{
    @Autowired
    ShopMapper shopMapper;
    @Override
    public List<Shop> GetAllShops() {
        return shopMapper.GetAllShops();

    }
}
