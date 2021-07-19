package com.project.professor.allocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.service.DepartmentService;

@RestController
@RequestMapping (path = "/department", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {
	
	 private final DepartmentService departmentService;
	 
	 public DepartmentController (DepartmentService departmentService) {
		 this.departmentService = departmentService;
	 }
	 @GetMapping(path = "/")
	 public ResponseEntity<List<Department>> findAll() {
		 List<Department> department = departmentService.findAll(null);
		 return new ResponseEntity <>(department, HttpStatus.OK);
	 }
	 @GetMapping (path = "/{department_id")
	 public ResponseEntity<Department> findById(@PathVariable(name = "department_id")Long id){
		 Department department = departmentService.findById(id);
		 if (department ==null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 } else {
			 return new ResponseEntity<>(department, HttpStatus.OK);
		 }
	 }

}
