package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Orders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Orders orders);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    /*根据用户Id查订单*/
    List<Orders> getOrderList(@Param("customerId") Integer customerId);


    List<Orders> selectAllShopOrder(int shopId, String orderStatus);

    List<Orders> selectTodayOrder(int shopId);

}