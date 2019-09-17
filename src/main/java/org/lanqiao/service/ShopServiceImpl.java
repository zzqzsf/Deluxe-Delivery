package org.lanqiao.service;

import org.lanqiao.entity.Shop;
import org.lanqiao.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	ShopMapper shopMapper;

	@Override
	public List<Shop> selectShopInfo(int shopId) {
		return null;
	}

	@Override
	public List<Shop> getShop(Integer shopId) {
		return shopMapper.getShop(shopId);
	}
}
