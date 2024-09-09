package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Subject;
import com.example.demo.utility.ResponceStructure;

public interface SubjectService 
{
	ResponceStructure<Subject> saveSubject(Subject s, String className);
	
	ResponceStructure<Subject> updateSubject(Subject s,int id);
	
	ResponceStructure<Subject> fetchSubjectById(int id);
	
	ResponceStructure<Subject> fetchSubjectByCode(String code);
	
	ResponceStructure<List<Subject>> fetchSubjectByClassName(String className);
	
	ResponceStructure<List<Subject>> fetchSubjectByStudentId(int id);
	
	ResponceStructure<Subject> deleteSubjectById(int id);
	
	ResponceStructure<Subject> deleteSubjectByCode(String code);

	
	
}
