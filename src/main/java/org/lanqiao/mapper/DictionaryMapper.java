package org.lanqiao.mapper;

import org.lanqiao.entity.Dictionary;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryMapper {


	int insertSelective(Dictionary record);
}