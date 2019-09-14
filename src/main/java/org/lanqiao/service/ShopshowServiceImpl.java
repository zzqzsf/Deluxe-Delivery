package org.lanqiao.service;

import org.lanqiao.entity.Shop;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
<<<<<<< HEAD
public class ShopshowServiceImpl implements ShopshowService {
=======
public class ShopShowServiceImpl implements ShopShowService {
>>>>>>> parent of db70341... 改
    @Autowired
    ShopMapper shopMapper;
    @Override
    public List<Shop> GetAllShops() {
        return shopMapper.GetAllShops();
<<<<<<< HEAD
//  hhggf
=======
>>>>>>> parent of db70341... 改
    }
}
