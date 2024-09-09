package com.example.demo.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Repository;

import com.example.demo.Exception.EntityAlreadyExist;
import com.example.demo.Exception.EntityNotPresentException;
import com.example.demo.dao.ClassDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dao.SubjectDao;
import com.example.demo.entity.Class;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;

@Repository
public class SubjectDaoImplementation implements SubjectDao
{

	@Autowired
	private SubjectRepository repository;
	
	@Autowired
	private ClassDao classDao;

	@Autowired
	private StudentDao studentDao;

	
	@Override
	public Subject saveSubject(Subject s, String className) 
	{
		Class fetchClassByName = classDao.fetchClassByName(className);
		if(repository.existsByCode(s.getCode()))
		{
			throw new EntityAlreadyExist("Subject is already present");
		}
		s.setClass_name(fetchClassByName);
		return repository.save(s);
	}
	

	@Override
	public Subject updateSubject(Subject s, int id) 
	{
		fetchSubjectByID(id);
		Optional<Subject> optional = repository.findByCode(s.getCode());

		if (optional.isPresent())
		{
			if (optional.get().getId() != id) 
			{
				throw new EntityAlreadyExist("subject is already present with the code " + s.getCode());
			}
		}
		s.setId(id);
		return repository.save(s);
	}

	@Override
	public Subject fetchSubjectByID(int id)
	{
		Optional<Subject> optional = repository.findById(id);
		return optional.orElseThrow(()-> new EntityAlreadyExist("this id is already present"));
	}

	@Override
	public Subject fetchSubjectByCode(String code) {
		Optional<Subject> optional = repository.findByCode(code);
		return optional.orElseThrow(()-> new EntityNotPresentException("this code is already present"));
	}

	@Override
	public List<Subject> fetchSubjectByClassName(String className) {
		Class fetchClassByName = classDao.fetchClassByName(className);
		return fetchClassByName.getSubject();
	}

	@Override
	public List<Subject> fetchSubjectByStudentId(int id) {
		Student fetchStudentByID = studentDao.fetchStudentByID(id);
		return null;
	}

	@Override
	public boolean deleteSubjectById(int id)
	{
		Subject subject = fetchSubjectByID(id);
		repository.delete(subject);
		return true;
	}


	@Override
	public boolean deleteSubjectByCode(String code) 
	{
		Subject subject = fetchSubjectByCode(code);
		repository.delete(subject);
		return true;
	}
	

	

}
