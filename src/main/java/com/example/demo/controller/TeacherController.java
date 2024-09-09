package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.TeacherService;
import com.example.demo.entity.Teacher;


import com.example.demo.utility.ResponceStructure;



@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherService service;

	@PostMapping("/save")
	public ResponseEntity<ResponceStructure<Teacher>> saveTeacher(@RequestBody Teacher s) {
		ResponceStructure<Teacher> structure = service.saveTeacher(s);
		return new ResponseEntity<ResponceStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponceStructure<Teacher>> updateTeacher(@RequestBody Teacher s,
			@PathVariable("id") int id) {
		ResponceStructure<Teacher> structure = service.updateTeacher(s,id);
		return new ResponseEntity<ResponceStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponceStructure<Teacher>> deleteTeacherByID(@PathVariable("id") int id) {
		ResponceStructure<Teacher> structure = service.deleteTeacherByID(id);
		return new ResponseEntity<ResponceStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByNUmber/{number}")
	public ResponseEntity<ResponceStructure<Teacher>> deleteTeacherByNumber(@PathVariable("number") String number) {
		ResponceStructure<Teacher> structure = service.deleteTeacherByNumber(number);
		return new ResponseEntity<ResponceStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponceStructure<Teacher>> fetchTeacherByID(@PathVariable("id") int id) {
		ResponceStructure<Teacher> structure = service.fetchTeacherByID(id);
		return new ResponseEntity<ResponceStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByNumber/{number}")
	public ResponseEntity<ResponceStructure<Teacher>> fetchTeacherByNumber(@PathVariable("number") String number) {
		ResponceStructure<Teacher> structure = service.fetchTeacherByNumber(number);
		return new ResponseEntity<ResponceStructure<Teacher>>(structure, HttpStatus.OK);
	}

	@GetMapping("/fetchByClassName/{className}")
	public ResponseEntity<ResponceStructure<List<Teacher>>> fetchTeachersByClassName(
			@PathVariable("className") String classsName) {
		ResponceStructure<List<Teacher>> structure = service.fetchTeachersByClassName(classsName);
		return new ResponseEntity<ResponceStructure<List<Teacher>>>(structure, HttpStatus.OK);
	}
}