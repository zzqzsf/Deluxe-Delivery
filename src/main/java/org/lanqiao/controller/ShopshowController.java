package org.lanqiao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Shop;
import org.lanqiao.service.ShopshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopshowController {
@Autowired
ShopshowService shopshowService;

    @RequestMapping("/getgoods")
    List<Shop> GetAllShops() {
        return shopshowService.GetAllShops();
    }


    @RequestMapping("/getAllShare")
    public PageInfo get(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

        PageHelper.startPage(pageNum, 3);

        List<Shop> shareList = shopshowService.GetAllShops();

        PageInfo<Shop> pageInfo = new PageInfo<>(shareList);

        return pageInfo;
    }
}
