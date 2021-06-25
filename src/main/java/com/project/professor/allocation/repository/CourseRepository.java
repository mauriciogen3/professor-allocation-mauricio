package com.project.professor.allocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long> {

	// Falta o find by name containing
	List<Course> findByBaneContaining(String course);  
}
