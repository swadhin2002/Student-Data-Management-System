package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Subject;

public interface SubjectDao 
{
	Subject saveSubject(Subject s,String className);
	
	Subject updateSubject(Subject s,int id);
	
	Subject fetchSubjectByID(int id);

	Subject fetchSubjectByCode(String code);

	List<Subject> fetchSubjectByClassName(String className);

	List<Subject> fetchSubjectByStudentId(int id);
	
	boolean deleteSubjectById(int id);
	
	boolean deleteSubjectByCode(String code);
}
