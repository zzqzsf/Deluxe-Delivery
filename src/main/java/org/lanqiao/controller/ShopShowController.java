package org.lanqiao.controller;


import org.lanqiao.entity.Shop;
import org.lanqiao.service.ShopShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopShowController {
@Autowired
ShopShowService shopShowService;

//    @RequestMapping("/getAllShare")
//    public PageInfo get(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
//
//        PageHelper.startPage(pageNum, 3);
//
//        List<Shop> shareList = shopShowService.GetAllShops();
//
//        PageInfo<Shop> pageInfo = new PageInfo<>(shareList);
//
//        return pageInfo;
//    }
//    solr
@Autowired
private SolrTemplate solrTemplate;

//    @RequestMapping("/save")
//    @ResponseBody
//    public String save() {
//        Shop Shop = new Shop();
//        Shop.setShopId(1);
//        Shop.setShopName("shijian");
//        solrTemplate.saveBean("Shop",Shop);
//        solrTemplate.commit("Shop");
//        return "success save !";
//    }
//
//    @RequestMapping("/get")
//    @ResponseBody
//    public Shop selectById() {
//        Optional<Shop> optional = solrTemplate.getById("Shop", 1, Shop.class);
//        return optional.get();//optional jdk1.8+ 解决空指针问题。
//    }
//
//    @RequestMapping("/del")
//    @ResponseBody
//    public int delById() {
//        UpdateResponse updateResponse = solrTemplate.deleteByIds("Shop","11");
//        return updateResponse.getStatus();//0 表示成功
//    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Shop> select() {
        // 查询所有
        Query query = new SimpleQuery();

        // 设置条件
        Criteria criteria = new Criteria("shopName").is("时间");
        query.addCriteria(criteria);

        //设置分页
        query.setOffset(0l); //开始索引(默认0)
        query.setRows(2);  //每页记录数(默认10)

        //设置排序规则
        Sort sort = new Sort(Sort.Direction.ASC, "");
        query.addSort(sort);

        //查询
        ScoredPage<Shop> pages = solrTemplate.queryForPage("meituan", query, Shop.class);
        System.out.println("pages.getTotalElements() = " + pages.getTotalElements());
        List<Shop> content = pages.getContent();
        return content;
    }


}
