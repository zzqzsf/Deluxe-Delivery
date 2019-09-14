package org.lanqiao.controller;

import org.lanqiao.entity.Address;
import org.lanqiao.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AddressController {
	@Autowired
	AddressService addressService;

	@RequestMapping("/addAddress")
	public int insert(Address address){
		return addressService.insert(address);
	}


	@RequestMapping("/getAddress")
	public List<Address> getAllAddress(){
		List<Address> addressList=addressService.getAllAddress();
		return addressList;

	}

	@RequestMapping("/getAddresss")
	public List<Address> getAllAddresss(){
		List<Address> addressList1=addressService.getAllAddresss();
		return addressList1;

	}

}
