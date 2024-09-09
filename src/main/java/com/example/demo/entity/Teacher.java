package com.example.demo.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	private char gender;
	@Column(nullable = false)
	private Date dob;
	@Column(unique = true,name = "phone_no")
	private String phoneNo;
	@OneToOne
	private Address address;
	@OneToOne(mappedBy = "mentor")
	private Class class_name;
	@ManyToMany(mappedBy = "teachers")
	private List<Subject> subjects;
	@ManyToMany(mappedBy = "teachers")
	private List<Class> all_classes;
	
	
}
