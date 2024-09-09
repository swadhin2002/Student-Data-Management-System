package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.SubjectService;
import com.example.demo.entity.Subject;
import com.example.demo.utility.ResponceStructure;

@RestController
@RequestMapping("/subject")
public class SubjectController 
{
	@Autowired
	private SubjectService service;
	
	@PostMapping("/save/{className}")
	public ResponseEntity<ResponceStructure<Subject>> saveSubject(@RequestBody Subject s,@PathVariable("className") String className)
	{
		ResponceStructure<Subject> structure = service.saveSubject(s, className);
		return new ResponseEntity<ResponceStructure<Subject>>(structure, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponceStructure<Subject>>updateSubject(@RequestBody Subject s,@PathVariable("id") int id)
	{
		ResponceStructure<Subject> structure = service.updateSubject(s, id);
		return new ResponseEntity<ResponceStructure<Subject>>(structure, HttpStatus.OK);
	}
	
	@GetMapping("/fetchSubjectById/{id}")
	public ResponseEntity<ResponceStructure<Subject>> fetchSubjectById(@PathVariable("id") int id)
	{
		ResponceStructure<Subject> structure = service.fetchSubjectById(id);
		return new ResponseEntity<ResponceStructure<Subject>>(structure, HttpStatus.OK);
	}
	
	@GetMapping("/fetchSubjectByCode/{code}")
	public ResponseEntity<ResponceStructure<Subject>> fetchSubjectByCode(@PathVariable("code") String code)
	{
		ResponceStructure<Subject> structure = service.fetchSubjectByCode(code);
		return new ResponseEntity<ResponceStructure<Subject>>(structure, HttpStatus.OK);
	}
	@GetMapping("/fetchSubjectStudentId/{id}")
	public ResponseEntity<ResponceStructure<List<Subject>>> fetchSubjectByStudentId(@PathVariable("id") int id)
	{
		ResponceStructure<List<Subject>> structure = service.fetchSubjectByStudentId(id);
		return new ResponseEntity<ResponceStructure<List<Subject>>>(structure, HttpStatus.OK);
	}
	@GetMapping("/fetchByClassName/{className}")
	public ResponseEntity<ResponceStructure<List<Subject>>> fetchSubjectByClass(@PathVariable("className") String className)
	{
		ResponceStructure<List<Subject>> structure = service.fetchSubjectByClassName(className);
		return new ResponseEntity<ResponceStructure<List<Subject>>>(structure, HttpStatus.OK);
	}
	@DeleteMapping("/deleteSubjectById/{id}")
	public ResponseEntity<ResponceStructure<Subject>> deleteSubjectById(@PathVariable("id") int id)
	{
		ResponceStructure<Subject> structure = service.deleteSubjectById(id);
		return new ResponseEntity<ResponceStructure<Subject>>(structure, HttpStatus.OK);
	}
	@DeleteMapping("/deleteSubjectByCode/{code}")
	public ResponseEntity<ResponceStructure<Subject>> deleteSubjectByCode(@PathVariable("code") String code)
	{
		ResponceStructure<Subject> structure = service.deleteSubjectByCode(code);
		return new ResponseEntity<ResponceStructure<Subject>>(structure, HttpStatus.OK);
	}
	
}
