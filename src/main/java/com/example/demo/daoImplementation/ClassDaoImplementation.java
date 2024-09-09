package com.example.demo.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Exception.EntityAlreadyExist;
import com.example.demo.Exception.EntityNotPresentException;
import com.example.demo.dao.ClassDao;
import com.example.demo.entity.Class;
import com.example.demo.repository.ClassRepository;

import jakarta.persistence.EntityNotFoundException;

@Repository
public class ClassDaoImplementation implements ClassDao {

	@Autowired
	private ClassRepository repository;

	@Override
	public Class saveClass(Class c)
	{
		checkIsPresent(c);
		return repository.save(c);
	}

	@Override
	public Class updateClass(Class c, int id) 
	{
		checkIsPresent(c);
		if (repository.existsById(id)) {
			c.setId(id);
			return repository.save(c);
		}
		throw new EntityNotPresentException("Classes are not present for the year" + id);
	}

	@Override
	public Class fetchClassById(int id) {
		Optional<Class> optional = repository.findById(id);
		return optional.orElseThrow(() -> new EntityNotPresentException("Class is not present with the Id " + id));
	}

	@Override
	public List<Class> fetchClassesByAcademicYear(int year) {
		if (!repository.existsByAcademicYear(year)) {
			throw new EntityNotFoundException("The class is not found of this yeat" + year);
		}
		return repository.findByAcademicYear(year);
	}

	@Override
	public boolean deleteClassById(int id) {
		repository.delete(fetchClassById(id));
		return true;
	}

	@Override
	public boolean deleteClassByAcademicYear(int year) {
		if(repository.existsByAcademicYear(year)) {
			repository.deleteByAcademicYear(year);
			return true;
		}
		throw new EntityNotPresentException("Classes are not available with the ACAdemic year : "+year);
		
	}
	@Override
	public Class fetchClassByName(String name) {
		Optional<Class> optional = repository.findByname(name);
		return optional.orElseThrow(()-> new EntityNotPresentException("Classes are not available with the  name : "+name));
	}

	private void checkIsPresent(Class c)
	{
		boolean year = repository.existsByAcademicYear(c.getAcademicYear());
		boolean id = repository.existsById(c.getId());
		if (year && id) 
		{
			throw new EntityAlreadyExist("Class data is already exists with year :" + c.getAcademicYear() + " and the name :" + c.getName());
		}
	}
}
