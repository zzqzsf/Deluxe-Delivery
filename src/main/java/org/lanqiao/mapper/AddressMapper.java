package org.lanqiao.mapper;

import org.lanqiao.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressMapper {
    int deleteByPrimaryKey(Integer addrId);

    int insert(Address address);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addrId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);


    List<Address> getAllAddress();
    List<Address> getAllAddresss();

}