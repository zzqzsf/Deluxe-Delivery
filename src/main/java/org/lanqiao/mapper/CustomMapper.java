package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.Custom;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomMapper {
    //检查手机号是否被注册
    int checkTel(String tel);
    //用户注册成功，插入数据
    int insertCustom(Custom custom);
    //用户登陆时手机号未注册 将自动注册 只插入手机号
    int insertCustom1(String cusTel);
    //检查用户名和密码是否匹配
    int checkCustom(Custom custom);
    //修改密码
    int updatePass(String cusTel,String cusPwd);
}
