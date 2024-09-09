package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Class;
public interface ClassDao
{
	Class saveClass(Class c);
	Class updateClass(Class c,int id);
	Class fetchClassById(int id);
	Class fetchClassByName(String name);
	List<Class> fetchClassesByAcademicYear(int year);
	boolean deleteClassById(int id);
	boolean deleteClassByAcademicYear(int year);
	
}
