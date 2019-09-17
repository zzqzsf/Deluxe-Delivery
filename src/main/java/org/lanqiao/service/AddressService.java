package org.lanqiao.service;

import org.lanqiao.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
	public int insert(Address address);

	public List<Address> getAllAddress(Integer cusId);

	public List<Address> getAllAddresss();
}
