package com.example.demo.Service;

import com.example.demo.entity.Address;
import com.example.demo.utility.ResponceStructure;

public interface AddressService 
{
	ResponceStructure<Address> save(Address a);
	
	ResponceStructure<Address> updateAddress(Address a,int id);
	
	ResponceStructure<Address> deleteAddress(int id);
	
	ResponceStructure<Address> fetchAddress(int id);	
}
