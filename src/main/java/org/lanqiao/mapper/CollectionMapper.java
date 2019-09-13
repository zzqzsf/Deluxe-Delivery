package org.lanqiao.mapper;

import org.lanqiao.entity.Collection;

public interface CollectionMapper {
    int insert(Collection record);

    int insertSelective(Collection record);
}