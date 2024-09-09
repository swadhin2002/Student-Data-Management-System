package com.example.demo.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Service.SubjectService;
import com.example.demo.dao.SubjectDao;
import com.example.demo.entity.Subject;
import com.example.demo.utility.ResponceStructure;

@Service
public class SubjectServiceImplementataion implements SubjectService 
{
	 
	@Autowired
	private SubjectDao dao;
	
	
	@Override
	public ResponceStructure<Subject> saveSubject(Subject s , String className) 
	{
		Subject subject = dao.saveSubject(s, className);
		return new ResponceStructure<Subject>(201,"data saved succesfully", subject, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Subject> updateSubject(Subject s, int id)
	{
		Subject subject = dao.updateSubject(s, id);
		return new ResponceStructure<Subject>(201,"data saved succesfully", subject, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Subject> fetchSubjectById(int id)
	{
		Subject subject = dao.fetchSubjectByID(id);
		return new ResponceStructure<Subject>(200,"data saved succesfully", subject, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Subject> fetchSubjectByCode(String code) 
	{
		Subject subject = dao.fetchSubjectByCode(code);
		return new ResponceStructure<Subject>(200,"data saved succesfully", subject, LocalDateTime.now());

	}

	@Override
	public ResponceStructure<List<Subject>> fetchSubjectByClassName(String className)
	{
		List<Subject> subject = dao.fetchSubjectByClassName(className);
		return new ResponceStructure<List<Subject>>(201,"data saved succesfully", subject, LocalDateTime.now());

	}

	@Override
	public ResponceStructure<List<Subject>> fetchSubjectByStudentId(int id)
	{
		List<Subject> subject = dao.fetchSubjectByStudentId(id);
		return new ResponceStructure<List<Subject>>(201,"data saved succesfully", subject, LocalDateTime.now());

	}

	@Override
	public ResponceStructure<Subject> deleteSubjectById(int id) 
	{
		dao.deleteSubjectById(id);
		return new ResponceStructure<Subject>(201,"data saved succesfully",null , LocalDateTime.now());

	}

	@Override
	public ResponceStructure<Subject> deleteSubjectByCode(String code)
	{
		boolean subject = dao.deleteSubjectByCode(code);
		return new ResponceStructure<Subject>(201,"data saved succesfully", null, LocalDateTime.now());

	}

}
