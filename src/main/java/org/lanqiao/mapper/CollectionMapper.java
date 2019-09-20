package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.Collections;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CollectionMapper {
    List<Collections> getCollectionShop(Integer customerId);

    int insertSelective(int cusId,int shopId);
}