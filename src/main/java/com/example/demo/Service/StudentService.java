package com.example.demo.Service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Student;
import com.example.demo.utility.ResponceStructure;
public interface StudentService {

	ResponceStructure<Student> saveStudent(Student s);

	ResponceStructure<Student> updateStudent(Student s, int id);

	ResponceStructure<Student> deleteStudentByID(int id);

	ResponceStructure<Student> deleteStudentByNumber(String number);

	ResponceStructure<Student> fetchStudentByID(int id);

	ResponceStructure<Student> fetchStudentByNumber(String number);

	ResponceStructure<List<Student>> fetchStudentsByClassName(String className);

}