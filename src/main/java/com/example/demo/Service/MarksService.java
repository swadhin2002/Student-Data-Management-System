package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Marks;
import com.example.demo.utility.ResponceStructure;

public interface MarksService 
{
	ResponceStructure<Marks> saveMarks(Marks mark,int studentId,int subjectId);
	
	ResponceStructure<Marks> updateMarks(Marks mark,int id);
	
	ResponceStructure<Marks> deleteMarks(int id);
	
	ResponceStructure<Marks> fetchMarksById(int id);
	
	ResponceStructure<List<Marks>> fetchMarksByStudentId(int studentId);
	
	ResponceStructure<List<Marks>> fetchMarksBySubjectId(int subjectId);
}
