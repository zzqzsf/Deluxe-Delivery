package org.lanqiao.service;

import org.lanqiao.entity.Custom;
import org.springframework.stereotype.Service;

public interface CustomService {
    int checkTel(String tel);
    int insertCustom(Custom custom);
    int insertCustom1(String cusTel);
    int checkCustom(Custom custom);
    int updatePass(String cusTel,String cusPwd);
}
