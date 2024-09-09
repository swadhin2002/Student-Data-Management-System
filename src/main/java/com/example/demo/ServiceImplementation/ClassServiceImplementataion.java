package com.example.demo.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.Service.ClassService;
import com.example.demo.dao.ClassDao;
import com.example.demo.entity.Class;
import com.example.demo.utility.ResponceStructure;

@Service
public class ClassServiceImplementataion implements ClassService {

	@Autowired
	private ClassDao dao;

	@Override
	public ResponceStructure<Class> save(Class c) {
		Class classWithId = dao.saveClass(c);
		return createResponseStructure(200, "Class details are saved inside the DB sauccesfully", classWithId);
	}

	@Override
	public ResponceStructure<Class> updateById(Class c, int id) {
		Class updateWithId = dao.updateClass(c, id);
		return createResponseStructure(200, "update With By Id", updateWithId);
	}

	@Override
	public ResponceStructure<Class> fetchById(int id) {
		Class fetchById = dao.fetchClassById(id);
		return createResponseStructure(200, "Class details are fetched succesfully", fetchById);
	}

	@Override
	public ResponceStructure<List<Class>> fetchClassesByAcademicYear(int year) {
		List<Class> fetchClassByAcademicYear = dao.fetchClassesByAcademicYear(year);
		return new ResponceStructure<List<Class>>(200, "List of Class details are fetched succesfully",
				fetchClassByAcademicYear, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Class> deleteById(int id) {
		dao.deleteClassById(id);
		return createResponseStructure(204, "dataDeleted With Id", null);

	}

	@Override
	public ResponceStructure<Class> deleteClassesByAcademeicYear(int year) {
		dao.deleteClassByAcademicYear(year);
		return createResponseStructure(204, "Class are deleted by academeic year", null);
	}

	private ResponceStructure<Class> createResponseStructure(int statusCode, String msg, Class data) {
		return new ResponceStructure<>(statusCode, msg, data, LocalDateTime.now());
	}

}
