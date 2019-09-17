package org.lanqiao.service;

import org.lanqiao.entity.Custom;
import org.lanqiao.mapper.CustomMapper;
import org.lanqiao.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

@Service
public class CustomServiceIml implements CustomService {

    @Autowired
    CustomMapper customMapper;

    @Resource
    private RedisUtil redisUtil;

    public int checkTel(String tel){

        return customMapper.checkTel(tel);
    }
    public int insertCustom(Custom custom){
        Object value = redisUtil.get("num");
        String defaultName = "user"+(String)value;
        int num = Integer.parseInt((String)value)+1;
        redisUtil.set("num","00000"+num+"");
        custom.setCusName(defaultName);
        return customMapper.insertCustom(custom);
    }
    public int insertCustom1(String cusTel){
        Object value = redisUtil.get("num");
        String defaultName = "user"+(String)value;
        int num = Integer.parseInt((String)value)+1;
        redisUtil.set("num","00000"+num+"");
        return customMapper.insertCustom1(cusTel,defaultName);
    }
    public int checkCustom(Custom custom){
        return customMapper.checkCustom(custom);
    }
    public int updatePass(String cusTel,String cusPwd){
        return customMapper.updatePass(cusTel,cusPwd);
    }
}
