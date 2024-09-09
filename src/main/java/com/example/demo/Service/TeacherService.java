package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Teacher;
import com.example.demo.utility.ResponceStructure;


public interface TeacherService 
{
	ResponceStructure<Teacher> saveTeacher(Teacher s);

	ResponceStructure<Teacher> updateTeacher(Teacher s, int id);

	ResponceStructure<Teacher> deleteTeacherByID(int id);

	ResponceStructure<Teacher> deleteTeacherByNumber(String number);

	ResponceStructure<Teacher> fetchTeacherByID(int id);

	ResponceStructure<Teacher> fetchTeacherByNumber(String number);

	ResponceStructure<List<Teacher>> fetchTeachersByClassName(String className);
}
