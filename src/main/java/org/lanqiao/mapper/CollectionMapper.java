package org.lanqiao.mapper;

import org.lanqiao.entity.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionMapper {

    int insertSelective(Collection record);
}