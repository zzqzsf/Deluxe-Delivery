package org.lanqiao.service;

import org.lanqiao.entity.Shop;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Service;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopMapper shopMapper;
    @Override
    public List<Shop> selectShopInfo(int shopId) {
        return null;
    }
}
