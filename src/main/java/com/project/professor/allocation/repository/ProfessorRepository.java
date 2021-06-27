package com.project.professor.allocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	// Falta o find by name containing
	// Não está no exercicio, mas coloca o find by department id

	List<Professor> findByDepartmentId(Long id);

	List<Professor> findByNameContainingIgnoreCase(String name);
}
