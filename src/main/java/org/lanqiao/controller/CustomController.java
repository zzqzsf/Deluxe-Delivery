package org.lanqiao.controller;

import org.lanqiao.entity.Custom;
import org.lanqiao.entity.Location;
import org.lanqiao.service.CustomService;
import org.lanqiao.util.RedisUtil;
import org.lanqiao.util.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class CustomController {

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;


    @Autowired
    CustomService customService;



    @RequestMapping("/checkTel")
    public int checkTel(String tel){
        //看该手机号在数据库中的条数
        int a = customService.checkTel(tel);
        if(a==1){//说明已经被注册
            return a;
        }else{//没有被注册发送验证码
            //发送验证码
            String verifyCode = SMSUtil.send(tel);
            System.out.println(verifyCode);
            //手机号和验证码作为键值对存入redis中
            redisUtil.set(tel,verifyCode,ExpireTime);
            return a;
        }
    }
    @RequestMapping("/checkTel1")
    public int checkTel1(String cusTel){
        return customService.checkTel(cusTel);
    }
    @RequestMapping("/checkVerifyCode")
    public boolean checkCode(String tel, String verifyCode){
        return verifyCode.equals(redisUtil.get(tel));
    }
    @RequestMapping("/insertCustom")
    public int insertCustom(Custom custom){
        if("".equals(custom.getCusPwd())){
            return 0;
        }else{
            int count = customService.insertCustom(custom);
            return count;
        }
    }
    @RequestMapping("/insertCustom1")
    public int insertCustom1(String cusTel){
        return customService.insertCustom1(cusTel);
    }
    @RequestMapping("/checkVerifyCode1")
    public Map cheeckCode1(String tel, String verifyCode, HttpServletRequest request){
        int rowNum = customService.checkTel(tel);
        boolean flag = verifyCode.equals(redisUtil.get(tel));
        Map map = new HashMap();
        map.put("rowNum",rowNum);
        map.put("flag",flag);
        if(flag){
            addSession(tel,request);
        }
        return map;
    }

    @RequestMapping("/sendVerifyCode")
    public boolean sendCode(String tel){
        String verifyCode = SMSUtil.send(tel);
        System.out.println(verifyCode);
        //手机号和验证码作为键值对存入redis中
        redisUtil.set(tel,verifyCode,ExpireTime);
        return true;
    }
    @RequestMapping("/checkCustom")
    public int checkCustom(Custom custom,HttpServletRequest request){
        int count = customService.checkCustom(custom);
        if(count == 1){
            addSession(custom.getCusTel(),request);
        }
        return count;
    }

    @RequestMapping("/updatePass")
    public int updatePass(String cusTel,String cusPwd){
        return customService.updatePass(cusTel,cusPwd);
    }

    @RequestMapping("/getUserId")
    public int getUserId(String cusTel){
        return customService.getUserId(cusTel);
    }

    public void addSession(String cusTel, HttpServletRequest request){
        request.getSession().setAttribute("cusTel",cusTel);
    }

    @RequestMapping("/getUserName")
    public String getUserName(String cusTel){
        String name = customService.getUserName(cusTel);
        return customService.getUserName(cusTel);
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request){
        Object sessionobj = request.getSession().getAttribute("cusTel");
        String session = (String) sessionobj;
        return session;
    }





}
