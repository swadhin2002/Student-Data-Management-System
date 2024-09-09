package com.example.demo.Service;

import com.example.demo.utility.ResponceStructure;

import java.util.List;

import com.example.demo.entity.Class;
public interface ClassService 
{
	ResponceStructure<Class> save (Class c);
	ResponceStructure<Class> updateById(Class c, int id);
	ResponceStructure<Class> fetchById(int id);
	ResponceStructure<List<Class>> fetchClassesByAcademicYear(int year);
	ResponceStructure<Class> deleteById(int id);
	ResponceStructure<Class> deleteClassesByAcademeicYear(int year);
}
