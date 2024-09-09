package com.example.demo.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.MarksService;
import com.example.demo.dao.MarksDao;
import com.example.demo.entity.Marks;
import com.example.demo.utility.ResponceStructure;

@Service
public class MarksServiceImplementataion implements MarksService
{
	@Autowired
	private MarksDao dao;

	@Override
	public ResponceStructure<Marks> saveMarks(Marks mark, int studentId, int subjectId) {
		Marks marks = dao.saveMarks(mark, studentId, subjectId);
		return new ResponceStructure<Marks>(201, "Marks object is saved inside the DB succesfully", marks,LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Marks> updateMarks(Marks mark, int id) {
		Marks marks = dao.updateMarks(mark, id);
		return new ResponceStructure<Marks>(201,"Marks object is updated inside the DB succesfully", marks, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Marks> deleteMarks(int id)
	{
	 dao.deleteMarks(id);
	 return new ResponceStructure<Marks>(201,"Marks object is updated inside the DB succesfully",null, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<Marks> fetchMarksById(int id)
	{
		Marks marks = dao.fetchMarksById(id);
		return new ResponceStructure<Marks>(201,"Marks object is updated inside the DB succesfully", marks, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<List<Marks>> fetchMarksByStudentId(int studentId)
	{
		List<Marks> marks = dao.fetchMarksByStudentId(studentId);
		return new ResponceStructure<List<Marks>>(201,"Marks object is updated inside the DB succesfully", marks, LocalDateTime.now());
	}

	@Override
	public ResponceStructure<List<Marks>> fetchMarksBySubjectId(int subjectId)
	{
		List<Marks> marks = dao.fetchMarksByStudentId(subjectId);
		return new ResponceStructure<List<Marks>>(200,"Marls object is fetched by subjectId succesfully",marks,LocalDateTime.now());
	}
}
