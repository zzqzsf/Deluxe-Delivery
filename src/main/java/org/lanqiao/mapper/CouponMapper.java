package org.lanqiao.mapper;

import org.lanqiao.entity.Coupon;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponMapper {
    int deleteByPrimaryKey(Integer couponId);



    int insertSelective(Coupon record);



    int updateByPrimaryKeySelective(Coupon record);

}