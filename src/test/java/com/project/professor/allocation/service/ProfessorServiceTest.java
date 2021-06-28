package com.project.professor.allocation.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorServiceTest {
	
	@Autowired
	private ProfessorService professorService;
	
	@Test
	public void findAll() {
		//Act
		List<Professor> professors = professorService.findAll();
		
		
		//Print
		System.out.println(professors);
  
	}

}
