package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long> {

	// Falta o find by name containing
	List<Course> findByNaneContainingIgnoreCase(String name);  
}
