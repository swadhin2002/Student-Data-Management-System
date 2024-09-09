package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Class;

public interface ClassRepository extends JpaRepository<Class, Integer> {
	public Optional<Class> findByname(String name);

	public boolean existsByName(String name);

	public boolean existsById(int id);

	public boolean existsByAcademicYear(int year);

	public List<Class> findByAcademicYear(int year);

	public void deleteByAcademicYear(int year);
}
