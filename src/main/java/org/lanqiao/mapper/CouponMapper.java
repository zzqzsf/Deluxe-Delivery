package org.lanqiao.mapper;

import org.lanqiao.entity.Coupon;

public interface CouponMapper {
    int deleteByPrimaryKey(Integer couponId);



    int insertSelective(Coupon record);



    int updateByPrimaryKeySelective(Coupon record);

}