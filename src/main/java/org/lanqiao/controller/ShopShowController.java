package org.lanqiao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Shop;
import org.lanqiao.service.ShopShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopShowController {
@Autowired
ShopShowService shopShowService;

    @RequestMapping("/getgoods")
    List<Shop> GetAllShops() {
        return shopShowService.GetAllShops();
    }


    @RequestMapping("/getAllShare")
    public PageInfo get(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

        PageHelper.startPage(pageNum, 3);

        List<Shop> shareList = shopShowService.GetAllShops();

        PageInfo<Shop> pageInfo = new PageInfo<>(shareList);

        return pageInfo;
    }
}
