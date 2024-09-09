package com.example.demo.daoImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Exception.EntityAlreadyExist;
import com.example.demo.dao.AddressDao;
import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;
@Repository
public class AddressDaoImplementation implements AddressDao 
{

	@Autowired
	private AddressRepository repository;
	@Override
	public Address saveAddress(Address a) 
	{
		return repository.save(a);
	}

	@Override
	public Address updateAddress(Address a, int id)
	{
		if(!repository.existsById(id))
		{
			throw new EntityAlreadyExist("This"+id+"is already exist");
		}
		a.setId(id);
		return repository.save(a);
	}

	@Override
	public boolean deleteAddress(int id) 
	{
		Address address = fetchAddress(id);
		repository.deleteById(id);
		return true;
	}

	@Override
	public Address fetchAddress(int id)
	{
		
		Optional<Address> optional = repository.findById(id);
		return optional.orElseThrow(() -> new EntityAlreadyExist("Adress with id " + id + " is not present"));
	}

}
