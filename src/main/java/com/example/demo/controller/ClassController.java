package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ClassService;
import com.example.demo.entity.Class;
import com.example.demo.utility.ResponceStructure;

@RestController
@RequestMapping("/class")
public class ClassController
{
	@Autowired
	private ClassService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponceStructure<Class>> save(@RequestBody Class c)
	{
		ResponceStructure<Class> structure = service.save(c);
		return new ResponseEntity<ResponceStructure<Class>>(structure,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponceStructure<Class>> update(@RequestBody Class c, @PathVariable("id") int id)
	{
		ResponceStructure<Class> structure = service.updateById(c,id);
		return new ResponseEntity<ResponceStructure<Class>>(structure,HttpStatus.OK);
	}
	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponceStructure<Class>> fetchClassById(@PathVariable("id") int id)
	{
		ResponceStructure<Class> structure = service.fetchById( id);
		return new ResponseEntity<ResponceStructure<Class>>(structure,HttpStatus.OK);
	}
	@GetMapping("/fetchByYear/{year}")
	public ResponseEntity<ResponceStructure<List<Class>>> fetchClassesByAcademiCYear(@PathVariable("year") int year) {
		ResponceStructure<List<Class>> structure = service.fetchClassesByAcademicYear(year);
		return new ResponseEntity<ResponceStructure<List<Class>>>(structure, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponceStructure<Class>> deleteById(@PathVariable("id") int id)
	{
		ResponceStructure<Class>structure = service.deleteById(id);
		return new ResponseEntity<ResponceStructure<Class>>(structure,HttpStatus.OK);
	}
	@DeleteMapping("/deleteByYear/{year}")
	public ResponseEntity<ResponceStructure<Class>> deleteClassBYYear(@PathVariable("year") int year) {
		ResponceStructure<Class> structure = service.deleteClassesByAcademeicYear(year);
		return new ResponseEntity<ResponceStructure<Class>>(structure, HttpStatus.OK);
	}

}
