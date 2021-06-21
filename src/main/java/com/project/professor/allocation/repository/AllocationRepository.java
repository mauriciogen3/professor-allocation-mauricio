package com.project.professor.allocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long>{

	//List <Allocation> findByLastnameAndFirstname(String lastname, String firstname)
	// Quero buscar todas as alocacoes em q1ue o curso tenha id 1
	List<Allocation> findByCourse (Course course);
	List<Allocation> findByCourseId(Long id);
	List<Allocation> findByProfessor (Professor professor);
	List<Allocation> findByProfessorId(Long id);
	

}
