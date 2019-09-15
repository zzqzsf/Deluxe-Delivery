package org.lanqiao.service;

import org.lanqiao.entity.Custom;
import org.lanqiao.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomServiceIml implements CustomService {

    @Autowired
    CustomMapper customMapper;

    public int checkTel(String tel){
        return customMapper.checkTel(tel);
    }
    public int insertCustom(Custom custom){
        return customMapper.insertCustom(custom);
    }
    public int insertCustom1(String cusTel){
        return customMapper.insertCustom1(cusTel);
    }
    public int checkCustom(Custom custom){
        return customMapper.checkCustom(custom);
    }
    public int updatePass(String cusTel,String cusPwd){
        return customMapper.updatePass(cusTel,cusPwd);
    }
}
