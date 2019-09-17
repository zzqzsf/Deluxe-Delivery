package org.lanqiao.mapper;

import org.lanqiao.entity.Collections;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionMapper {

    int insertSelective(Collections record);
}