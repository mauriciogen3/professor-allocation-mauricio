package com.project.professor.allocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Allocation;
//import com.project.professor.allocation.entity.Course;
//import com.project.professor.allocation.entity.Professor;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long>{

	//List <Allocation> findByLastnameAndFirstname(String lastname, String firstname)
	// Quero buscar todas as alocacoes em q1ue o curso tenha id 1
	
	// São equivalentes. No primeiro é obrigatório setar o ID do curso 
//	List<Allocation> findByCourse (Course course);
	List<Allocation> findByCourseId(Long id);
	
	// São equivalentes. No primeiro é obrigatório setar o ID do professor
//	List<Allocation> findByProfessor (Professor professor);
	//Então no caso so preciso deixar apenas 1 desses ja que sao equivalentes?
	List<Allocation> findByProfessorId(Long id);
	

}
