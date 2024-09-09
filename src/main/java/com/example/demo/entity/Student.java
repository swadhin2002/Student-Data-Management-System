package com.example.demo.entity;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	//@Column(nullable = false)
	private Date dob;
	@Column(unique = true, name = "phone_no")
	private String phoneNo;
	private char gender;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy = "student")
	private List<Marks> marks;
	
	@ManyToOne
	private Class c;
	
}
