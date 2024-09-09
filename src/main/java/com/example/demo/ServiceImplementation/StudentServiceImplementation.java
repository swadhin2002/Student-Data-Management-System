package com.example.demo.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.StudentService;
import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.utility.ResponceStructure;


@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public ResponceStructure<Student> saveStudent(Student s) {
		Student student = dao.saveStudent(s);
		return new ResponceStructure<>(201, "Student data is saved succesfully", student, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Student> updateStudent(Student s, int id) {
		Student student = dao.updateStudent(s, id);
		return new ResponceStructure<>(200, "Student data is updated succesfully", student, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Student> deleteStudentByID(int id) {
		boolean b = dao.deleteStudentByID(id);
		return new ResponceStructure<>(204, "Student is deleted succesfully", null, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Student> deleteStudentByNumber(String number) {
		boolean b = dao.deleteStudentByNumber(number);
		return new ResponceStructure<>(204, "Student is deleted succesfully", null, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Student> fetchStudentByID(int id) {
		Student student = dao.fetchStudentByID(id);
		return new ResponceStructure<>(200, "Student data is fetched succesfully", student, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Student> fetchStudentByNumber(String number) {
		Student student = dao.fetchStudentByNumber(number);
		return new ResponceStructure<>(200, "Student data is fetched succesfully", student, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<List<Student>> fetchStudentsByClassName(String className) {
		List<Student> list = dao.fetchStudentsByClassName(className);
		return new ResponceStructure<>(200, "List of Students data is fetched succesfully", list, LocalDateTime.now());
	}

}








