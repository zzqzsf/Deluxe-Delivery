package org.lanqiao.service;

import org.lanqiao.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
	public List<Shop> selectShopInfo(int shopId);

	public List<Shop> getShop(Integer shopId);
}
