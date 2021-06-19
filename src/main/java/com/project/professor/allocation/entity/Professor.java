package com.project.professor.allocation.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

// Uma boa prática é sempre deixar a classe identada (Aperta Ctrl + Shift + f).
// Replicar isso nas outras classes.
// Falta o relacionamento com alocação. Lembrar que o mapeamento é bidirecional.

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String cpf;
private String name;


@OnDelete(action = OnDeleteAction.CASCADE)

@ManyToOne(optional = false)// nesse caso temos vários professores para um departamento
private Department department;


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
