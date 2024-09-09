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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MarksService;
import com.example.demo.entity.Marks;
import com.example.demo.utility.ResponceStructure;

@RestController
@RequestMapping("/mark")
public class MarksController
{
	@Autowired
	private MarksService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponceStructure<Marks>> saveMarks(@RequestBody Marks marks,@RequestParam("studentId") int studentId,@RequestParam("subjectId") int subjectId )
	{
		ResponceStructure<Marks> structure = service.saveMarks(marks, studentId, subjectId);
		return new ResponseEntity<ResponceStructure<Marks>>(structure,HttpStatus.OK);
	}
	
	@PutMapping("/updateMarks/{id}")
	public ResponseEntity<ResponceStructure<Marks>> updateMarks(@RequestBody Marks m,@PathVariable("id") int id)
	{
		ResponceStructure<Marks> structure= service.updateMarks(m, id);
		return new ResponseEntity<ResponceStructure<Marks>>(structure,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponceStructure<Marks>> deleteMarksById(@PathVariable("id") int id)
	{
		ResponceStructure<Marks> structure = service.deleteMarks(id);
		return new ResponseEntity<ResponceStructure<Marks>>(structure,HttpStatus.OK);
	}
	
	@GetMapping("/fetchMarksByStudentID/{id}")
	public ResponseEntity<ResponceStructure<List<Marks>>> fetchMarksByStudentId(@PathVariable("id") int id)
	{
		ResponceStructure<List<Marks>> structure = service.fetchMarksByStudentId(id);
		return new ResponseEntity<ResponceStructure<List<Marks>>>(structure,HttpStatus.OK);
	}
	@GetMapping("/fetchMarks/{id}")
	public ResponseEntity<ResponceStructure<Marks>> fetchMarksById(@PathVariable("id") int id)
	{
		ResponceStructure<Marks> structure = service.fetchMarksById(id);
		return new ResponseEntity<ResponceStructure<Marks>>(structure,HttpStatus.OK);
	}
	@GetMapping("/fetchMarksBySubject/{id}")
	public ResponseEntity<ResponceStructure<List<Marks>>> fetchMarksBySubjectId(@PathVariable("id") int SubjectId)
	{
		return null;
	}
	
	
}
