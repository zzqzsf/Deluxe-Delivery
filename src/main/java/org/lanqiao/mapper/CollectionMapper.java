package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.Collections;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CollectionMapper {

    int insertSelective(int cusId,int shopId);
}