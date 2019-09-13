package org.lanqiao.mapper;

import org.lanqiao.entity.Dictionary;

public interface DictionaryMapper {
    int insert(Dictionary record);

    int insertSelective(Dictionary record);
}