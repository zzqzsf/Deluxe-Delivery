package org.lanqiao.controller;

import org.lanqiao.entity.*;
import org.lanqiao.service.ShopService;
import org.lanqiao.util.RedisUtil;
import org.lanqiao.util.UUIDUtil;
import org.lanqiao.util.faceUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.google.gson.internal.bind.TypeAdapters.UUID;
@EnableTransactionManagement
@RestController
public class ShopController {
    @Autowired
    ShopService shopService;

    @Resource
    private RedisUtil redisUtil;
    @RequestMapping("/ajaxRedis")
    public boolean ajaxRedis(int shopId){
        String shop = String.valueOf(shopId);
        boolean ispresence=redisUtil.hasKey(shop);
        return ispresence;
    }

    @RequestMapping("/getShop")
    public List<Shop> getShop(Integer shopId){
        return shopService.getShop(shopId);
    }


    @RequestMapping("/getShopId")
    public int getShopId(HttpServletRequest request){
        HttpSession session = request.getSession();
        int shopId = (int)session.getAttribute("shopId");
        return shopId;

    }


    @RequestMapping("/insertFood")
    public Map<String,Object> insertFood(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result= new HashMap<String, Object>();

        // 转型为MultipartHttpRequest：
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
//        name是input的name值
        MultipartFile file= multipartRequest.getFile("foodImg");
        String a=null;
        try{
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
            String fileName = file.getOriginalFilename();
            String fileExtension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            System.out.println("完整的上传路径:" + upload.getAbsolutePath() + "/" + fileExtension);
//            根据foodImg大小，准备一个字节数组
            byte[] bytes = file.getBytes();
//            通过项目路径，拼接上传路径
            a= upload.getAbsolutePath() + "/" + UUIDUtil.get32UUID() + fileExtension;
            Path path = Paths.get(a);
//            开始将源文件写入目标地址
            Files.write(path,bytes);
            String b=a.replace("D:\\ideaworkspace\\Deluxe-Delivery\\target\\classes\\tatic","/upload");
            Map<String, String[]> map = multipartRequest.getParameterMap();
            Food food = new Food();

            String shopId= map.get("shopId")[0];
            String foodName = map.get("foodName")[0];
            String foodPrice = map.get("foodPrice")[0];
            String foodStock = map.get("foodStock")[0];
            String foodIntro = map.get("foodIntro")[0];
            String ftyId = map.get("ftyId")[0];
            String isInsert = map.get("isInsert")[0];

            int f1=Integer.parseInt(shopId);
            int f2=Integer.parseInt(foodStock);
            int f3=Integer.parseInt(ftyId);
            food.setShopId(f1);
            food.setFoodPath(b);
            food.setFoodName(foodName);
            food.setFoodPrice(foodPrice);
            food.setFoodIntro(foodIntro);
            food.setFtyId(f3);

            if(isInsert!=null){
                food.setFoodStatus("上架");
                shopService.insertFood(food);
            }else{
                shopService.updateFoodInfo(food);
            }

            result.put("msg", "上传成功！");
            result.put("result", true);
            result.put("foodImg",b);

        }catch(IOException e){
            result.put("msg","出错了");
            result.put("result",false);
            e.printStackTrace();
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return result;
    }
@RequestMapping("/updateFood")
    public Map<String,Object> updateFood(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result= new HashMap<String, Object>();

        // 转型为MultipartHttpRequest：
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
//        name是input的name值
        MultipartFile file= multipartRequest.getFile("updateFoodImg");
        String a=null;
        try{
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
            String fileName = file.getOriginalFilename();
            String fileExtension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            System.out.println("完整的上传路径:" + upload.getAbsolutePath() + "/" + fileExtension);
//            根据foodImg大小，准备一个字节数组
            byte[] bytes = file.getBytes();
//            通过项目路径，拼接上传路径
            a= upload.getAbsolutePath() + "/" + UUIDUtil.get32UUID() + fileExtension;
            Path path = Paths.get(a);
//            开始将源文件写入目标地址
            Files.write(path,bytes);
            String b=a.replace("D:\\ideaworkspace\\Deluxe-Delivery\\target\\classes\\tatic","/upload");
            Map<String, String[]> map = multipartRequest.getParameterMap();
            Food food = new Food();

            String shopId= map.get("shopId")[0];
            String foodName = map.get("foodName")[0];
            String foodPrice = map.get("foodPrice")[0];
            String foodStock = map.get("foodStock")[0];
            String foodIntro = map.get("foodIntro")[0];
            String ftyId = map.get("ftyId")[0];
            String isInsert = map.get("isInsert")[0];

            int f1=Integer.parseInt(shopId);
            int f2=Integer.parseInt(foodStock);
            int f3=Integer.parseInt(ftyId);
            food.setShopId(f1);
            food.setFoodPath(b);
            food.setFoodName(foodName);
            food.setFoodPrice(foodPrice);
            food.setFoodIntro(foodIntro);
            food.setFtyId(f3);

            if(isInsert!=null){
                food.setFoodStatus("上架");
                shopService.insertFood(food);
            }else{
                shopService.updateFoodInfo(food);
            }

            result.put("msg", "上传成功！");
            result.put("result", true);
            result.put("foodImg",b);

        }catch(IOException e){
            result.put("msg","出错了");
            result.put("result",false);
            e.printStackTrace();
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/updateShopImg")
    public Map<String,Object> updateShopImg(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> result= new HashMap<String, Object>();

        // 转型为MultipartHttpRequest：
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
        MultipartFile file= multipartRequest.getFile("updateShopImg");
        String a=null;
        try{
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
            String fileName = file.getOriginalFilename();
            String fileExtension = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            System.out.println("完整的上传路径:" + upload.getAbsolutePath() + "/" + fileExtension);
//            根据foodImg大小，准备一个字节数组
            byte[] bytes = file.getBytes();
//            通过项目路径，拼接上传路径
            a= upload.getAbsolutePath() + "/" + UUIDUtil.get32UUID() + fileExtension;
            Path path = Paths.get(a);
//            开始将源文件写入目标地址
            Files.write(path,bytes);
            String b=a.replace("D:\\ideaworkspace\\Deluxe-Delivery\\target\\classes/\\tatic","/upload");
            Map<String, String[]> map = multipartRequest.getParameterMap();
            Shop shop =new Shop();
            shop.setShopImg(b);
            String shopId= map.get("shopId")[0];
            int f=Integer.parseInt(shopId);
            shop.setShopId(f);
            shopService.updateShopInfo(shop);
            result.put("msg", "上传成功！");
            result.put("result", true);
            result.put("shopImg",b);

        }catch(IOException e){
            result.put("msg","出错了");
            result.put("result",false);
            e.printStackTrace();
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return result;
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
//    @RequestMapping("/insertFood")
//    public int insertFood(Food food){
//        return shopService.insertFood(food);
//    }
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
//    订单详情
    @RequestMapping("/selectOrderItemByOrderId")
    public List<OrderItem> selectOrderItemByOrderId(int orderId){
        return shopService.selectOrderItemByOrderId(orderId);
    }
//    预计订单
    @RequestMapping("/selectExpectOrder")
    public List<Orders> selectExpectOrder(int shopId){
        return shopService.selectExpectOrder(shopId);
    }
//    修改订单表的订单状态，同时往订单状态表插数据
    @RequestMapping("/updateOrderStatus")
    public void updateOrderStatus(Orders orders){
        shopService.updateOrderStatus(orders);
    }
//    订单状态
    @RequestMapping("/selectOrderStatus")
    public List<OrderStatus> selectOrderStatus(int orderId){
        return shopService.selectOrderStatus(orderId);
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
