package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Orders;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;


@Service
import java.util.List;

@Component
public interface OrdersMapper {
	int deleteByPrimaryKey(Integer orderId);

	int insert(Orders orders);

	int insertSelective(Orders record);

	Orders selectByPrimaryKey(Integer orderId);

	int updateByPrimaryKeySelective(Orders record);

	int updateByPrimaryKey(Orders record);
    List<Orders> getAllOrder(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize );
}