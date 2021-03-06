package com.project.professor.allocation.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String cpf;
private String name;

@JsonIgnoreProperties({"professor"})
@ManyToOne(optional = false)// nesse caso temos vários professores para um departamento
private Department department;

@OnDelete(action = OnDeleteAction.CASCADE)
@OneToMany(mappedBy = "professor")
private List<Allocation> allocations;


public Professor() {
	super();
}
public Professor(Long id, String cpf, String name, Department department) {
	super();
	this.id = id;
	this.cpf = cpf;
	this.name = name;
	this.department = department;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}





}
