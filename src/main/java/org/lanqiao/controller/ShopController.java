package org.lanqiao.controller;


import org.lanqiao.entity.Orders;
import org.lanqiao.service.OrderService;
import org.lanqiao.entity.Comment;
import org.lanqiao.entity.Food;
import org.lanqiao.entity.Foodtype;
import org.lanqiao.entity.Shop;
import org.lanqiao.service.ShopService;
import org.lanqiao.util.UUIDUtil;
import org.lanqiao.util.faceUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.google.gson.internal.bind.TypeAdapters.UUID;

@RestController
public class ShopController {
    @Autowired
    ShopService shopService;
    @RequestMapping("/getShop")
    public List<Shop> getShop(Integer shopId){
        return shopService.getShop(shopId);
    }


    @RequestMapping("/uploadFoodImg")
    public String uploadFoodImg(MultipartFile foodImg) {
        if (foodImg.isEmpty()) {
            return "请选择头像";
        }
        String a=null;
        try {
//            构建上传目标路径，找到项目的target的classes目录
            File destFile = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!destFile.exists()) {
                destFile = new File("");
            }
//            输出目标文件的绝对路径
            System.out.println("file path:" + destFile.getAbsolutePath());
//            拼接子路径，已时间日期创建文件夹
            Date date = new Date();
            File upload = new File(destFile.getAbsolutePath(), "static/" + new SimpleDateFormat("yyyyMMdd").format(date));
//            若目标文件夹不存在，则创建
            if (!upload.exists()) {
                upload.mkdirs();
            }
//            使用UUID重命名文件
            String fileName = foodImg.getOriginalFilename();
            String fileExtension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            System.out.println("完整的上传路径:" + upload.getAbsolutePath() + "/" + fileExtension);
//            根据foodImg大小，准备一个字节数组
            byte[] bytes = foodImg.getBytes();
//            通过项目路径，拼接上传路径
            a= upload.getAbsolutePath() + "/" + UUIDUtil.get32UUID() + fileExtension;
            Path path = Paths.get(a);
//            开始将源文件写入目标地址
            Files.write(path,bytes);
            Food food = new Food();

            food.setFoodId(1);
            food.setFoodPath(a);
            shopService.updateFoodInfo(food);


        }catch(IOException e){
            e.printStackTrace();
        }
        return a;
    }



    @RequestMapping("/checkShopName")
    public Boolean checkShopName(String shopName){
        if (shopService.checkShopName(shopName)==null){
            return true;
        }
        else{
            return false;
        }
    }

    //新增商铺
    @RequestMapping("/insertShop")
    public int insertShop(Shop shop, MultipartFile file, HttpServletRequest request) throws Exception {
        shop.setShopImg(new faceUpload().upload(request,file));
        return shopService.insertShop(shop);
    }
    @RequestMapping("/selectShopInfo")
    public Shop selectShopInfo(int shopId){
        return shopService.selectShopInfo(shopId);
    }

    @RequestMapping("/updateShopInfo")
    public int updateShopInfo(Shop shop){
        return shopService.updateShopInfo(shop);
    }
//    food
    @RequestMapping("/selectFoodByFoodtype")
    public List<Food> selectFoodByFoodtype(int foodtypeId){
        return shopService.selectFoodByFoodtype(foodtypeId);
    }
    @RequestMapping("/insertFood")
    public int insertFood(Food food){
        return shopService.insertFood(food);
    }
    @RequestMapping("/updateFoodInfo")
    public int updateFoodInfo(Food food){
        return shopService.updateFoodInfo(food);
    }
    @RequestMapping("/deleteFood")
    public int deleteFood(int foodId){
        return shopService.deleteFood(foodId);
    }
//   foodtype
    @RequestMapping("/selectFoodtype")
    public List<Foodtype> selectFoodtype(int shopId){
        return shopService.selectFoodtypeList(shopId);
    }
    @RequestMapping("insertFoodtype")
    public int insertFoodtype(Foodtype foodtype){
        return shopService.insertFoodtype(foodtype);
    }
    @RequestMapping("deleteFoodtype")
    public int deleteFoodtype(int foodtypeId){
        return shopService.deleteFootype(foodtypeId);
    }
    @RequestMapping("updateFoodtype")
    public int updateFoodtype(Foodtype foodtype){
        return shopService.updateFoodtype(foodtype);
    }
//    订单

//    评价
}
