package org.lanqiao.mapper;

import org.lanqiao.entity.ConCus;
import org.springframework.stereotype.Repository;

@Repository
public interface ConCusMapper {


    int insertSelective(ConCus record);
}