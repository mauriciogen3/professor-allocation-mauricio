package com.project.professor.allocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	/*
	 * buscar todos os departamentos que o nome contenha "mento" SELECT * FROM
	 * Department WHERE name LIKE %mento%
	 * 
	 * DB: departamento de fisica departamento de quimica portugues
	 * 
	 * nesse caso o resultado sera apenas: departamento de fisica departamento de
	 * quimica
	 */
	List<Department> findByNameContaining(Long id);

	List<Department> findByNameContaining(String name);

}
