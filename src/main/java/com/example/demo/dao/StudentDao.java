package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentDao
{

	Student saveStudent(Student s);

	Student updateStudent(Student s, int id);

	boolean deleteStudentByID(int id);

	boolean deleteStudentByNumber(String number);

	Student fetchStudentByID(int id);

	Student fetchStudentByNumber(String number);

	List<Student> fetchStudentsByClassName(String className);

}
