package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;

import com.project.professor.allocation.repository.CourseRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	// FIND ALL
	public List<Course> findAll() {
		List<Course> course  = courseRepository.findAll();
		return course;
	}

	// FIND BY ID
	public Course findById(Long id) {
		Optional<Course> optional = courseRepository.findById(id);
		Course C = optional.orElse(null);
		return C;
		}
	
	// CREATE
	public Course Create(Course course) {
		course.setId(null);
		return course;

	}
	// UPDATE
	public Course update(Course course) {
		boolean exists = courseRepository.existsById(course.getId());
		if (exists) {
			return course;
		} else {
			return null;
		}

	}

	// DELETE
	public void deleteById(Long CourseId) {
		//if (id !=null && courseRepository.existsById(id)) {
		//courseRepository.deleteById(id); }
		//NO SLIDE ESTAVA COMO NO MODELO COMENTADO ACIMA, ALTEREI COMO BASE O QUE FOI VISTO NA AULA.
		boolean exists = courseRepository.existsById(CourseId);
		if(exists) {
			courseRepository.deleteById(CourseId);
		
		}
		
	   // public void deleteAll() {
	      //  courseRepository.deleteAllInBatch();
		// O MESMO PROBLEMA EM ALLOCATION
		
	}

}
