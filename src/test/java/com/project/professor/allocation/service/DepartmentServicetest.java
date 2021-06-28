package com.project.professor.allocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentServicetest {

	@Autowired
	private DepartmentService departmentService;
	
	@Test
	public void findAll() {
		//Act
		List<Department> department = departmentService.findAll(null);
		
		
		//Print
		System.out.println(department);
}
	
}
