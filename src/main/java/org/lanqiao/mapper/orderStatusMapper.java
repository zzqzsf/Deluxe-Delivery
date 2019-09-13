package org.lanqiao.mapper;

import org.lanqiao.entity.orderStatus;

public interface orderStatusMapper {
    int insert(orderStatus record);

    int insertSelective(orderStatus record);
}