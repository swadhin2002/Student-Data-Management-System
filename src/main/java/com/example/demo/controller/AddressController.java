package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.AddressService;
import com.example.demo.entity.Address;
import com.example.demo.utility.ResponceStructure;

@Repository
@RequestMapping("/address")
public class AddressController
{
	@Autowired
	private AddressService service;
	
	@PutMapping("/update{id}")
	public ResponseEntity<ResponceStructure<Address>> update(@RequestBody Address a,@PathVariable("id") int id)
	{
		ResponceStructure<Address> structure = service.updateAddress(a, id);
		return new ResponseEntity<ResponceStructure<Address>>(structure,HttpStatus.OK);
	}
	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<ResponceStructure<Address>> fetchById(@PathVariable("id") int id)
	{
		ResponceStructure<Address>structure = service.fetchAddress(id);
		return new ResponseEntity<ResponceStructure<Address>>(structure,HttpStatus.OK);
	}
	
}
