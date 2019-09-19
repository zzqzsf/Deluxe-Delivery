package org.lanqiao.mapper;

import org.lanqiao.entity.Collections;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionMapper {
    List<Collections> getCollectionShop(Integer customerId);

    int insertSelective(Collections record);
}