package com.project.professor.allocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.service.CourseService;

@RestController
@RequestMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
	
	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		
		this.courseService = courseService;
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Course>> findAll() {
		List<Course>course = courseService.findAll();
		return new ResponseEntity<> (course, HttpStatus.OK);
	}
	@GetMapping(path = "/{course_id")
	public ResponseEntity<Course> findById(@PathVariable (name = "course_id")Long id){
		Course course = courseService.findById(id);
		if(course ==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}else {
			return new ResponseEntity<>(course, HttpStatus.OK);
		}
	}

}
