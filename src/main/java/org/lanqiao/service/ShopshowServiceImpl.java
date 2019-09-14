package org.lanqiao.service;

import org.lanqiao.entity.Shop;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopshowServiceImpl implements ShopshowService {
    @Autowired
    ShopMapper shopMapper;
    @Override
    public List<Shop> GetAllShops() {
        return shopMapper.GetAllShops();
//  hhggf
    }
}
