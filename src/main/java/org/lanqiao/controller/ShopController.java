package org.lanqiao.controller;

import org.lanqiao.entity.*;
import org.lanqiao.service.ShopService;
import org.lanqiao.util.RedisUtil;
import org.lanqiao.util.UUIDUtil;
import org.lanqiao.util.faceUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class ShopController {
    @Autowired
    ShopService shopService;

    @Resource
    private RedisUtil redisUtil;
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
    //向Redis插入店铺信息
    @RequestMapping("/insertLoction")
    public int insertShop(String jingdu,String weidu,String name){

        Location location = new Location();
        location.setName(name);
        location.setJingdu(Double.parseDouble(jingdu));
        location.setWeidu(Double.parseDouble(weidu));
        //将店名、经纬度存入redis
        redisUtil.lSet("locations",location);
        return 1;
    }
    //新增商铺
    @RequestMapping("/insertShop")
    public int insertShop(Shop shop,MultipartFile file, HttpServletRequest request) throws Exception {

//        Location location = new Location();
//        location.setName(shop.getShopName());
//        location.setJingdu(Double.parseDouble(jingdu));
//        location.setWeidu(Double.parseDouble(weidu));
//        //将店名、经纬度存入redis
//        redisUtil.lSet("locations",location);

        shop.setShopImg(new faceUpload().upload(request,file));
        return  shopService.insertShop(shop);

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
    public List<Food> selectFoodByFoodtype(int foodtypeId,String foodStatus,Integer foodStock){
        return shopService.selectFoodByFoodtype(foodtypeId,foodStatus,foodStock);
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
    @RequestMapping("/insertFoodtype")
    public int insertFoodtype(Foodtype foodtype){
        return shopService.insertFoodtype(foodtype);
    }
    @RequestMapping("/deleteFoodtype")
    public int deleteFoodtype(int foodtypeId){
        return shopService.deleteFootype(foodtypeId);
    }
    @RequestMapping("/updateFoodtype")
    public int updateFoodtype(Foodtype foodtype){
        return shopService.updateFoodtype(foodtype);
    }
//    评价
    @RequestMapping("/selectAllComment")
    public List<Comment> selectAllComment(int shopId,String comLevel){
        return shopService.selectAllComment(shopId,comLevel);
    }
//    添加商家回复
    @RequestMapping("/submitShopRsp")
    public int submitShopRsp(Comment comment){
        return shopService.submitShopRsp(comment);
    }

//    订单
    @RequestMapping("/selectAllShopOrder")
    public List<Orders> selectAllShopOrder(int shopId,String orderStatus){
        return shopService.selectAllShopOrder(shopId,orderStatus);
    }
    @RequestMapping("/selectTodayOrder")
    public List<Orders> selectTodayOrder(int shopId){
        return  shopService.selectTodayOrder(shopId);
    }

//    检查店铺手机号是否存在
    @RequestMapping("/checkShopTel")
    public  boolean checkShopTel(String shopTel){
        if (shopService.checkShopName(shopTel)!=null){
            return true;
        }
        else {
            return false;
        }
    }
   @RequestMapping("/checkShopPass")
    public  boolean checkShopTel(String shopTel,String shopPwd){
      if (shopService.checkShopPass(shopTel,shopPwd)==1){
      return true;
      }
      else {
          return false;
      }
   }
}
