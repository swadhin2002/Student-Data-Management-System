package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Marks;

public interface MarksDao 
{
	Marks saveMarks(Marks mark,int studentId,int subjectId);
	 
	Marks updateMarks(Marks mark,int id);
	
	boolean deleteMarks(int id); 
	
	Marks fetchMarksById(int id); 
	  
	List<Marks> fetchMarksByStudentId(int studentId);
	
	List<Marks> fetchMarksBySubjectId(int subjectId);
	
}
