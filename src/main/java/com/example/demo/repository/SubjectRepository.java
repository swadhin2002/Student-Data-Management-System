package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> 
{
	public boolean existsByCode(String code);
	public Optional<Subject> findByCode(String code);

	
}
