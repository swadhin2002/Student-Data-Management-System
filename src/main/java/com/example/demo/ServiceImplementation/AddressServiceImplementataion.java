package com.example.demo.ServiceImplementation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.AddressService;
import com.example.demo.dao.AddressDao;
import com.example.demo.entity.Address;
import com.example.demo.utility.ResponceStructure;
@Service
public class AddressServiceImplementataion implements AddressService 
{

	@Autowired
	private AddressDao dao;
	
	@Override
	public ResponceStructure<Address> save(Address a)
	{
		Address address = dao.saveAddress(a);
		return new ResponceStructure<Address>(201,"Address saves Succesfully", address, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Address> updateAddress(Address a, int id)
	{
		Address address = dao.updateAddress(a, id);
		return new ResponceStructure<Address>(201,"Address updated Succesfully", address, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Address> deleteAddress(int id)
	{
		dao.deleteAddress(id);
		return new ResponceStructure<Address>(201,"Address deleted Succesfully", null, LocalDateTime.now());

	}

	@Override
	public ResponceStructure<Address> fetchAddress(int id)
	{
		Address address = dao.fetchAddress(id);
		return new ResponceStructure<Address>(201,"Address saves Succesfully", address, LocalDateTime.now());
	}
	
}
