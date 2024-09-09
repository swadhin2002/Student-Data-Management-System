package com.example.demo.dao;

import com.example.demo.entity.Address;

public interface AddressDao
{
	Address saveAddress (Address a);
	
	Address updateAddress(Address a , int id);
	
	boolean deleteAddress(int id);
	
	Address fetchAddress(int id);
}
