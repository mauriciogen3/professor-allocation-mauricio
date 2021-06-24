package com.project.professor.allocation.repository;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) 
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class AllocationRepositoryTest {
	
	@Autowired
	private AllocationRepository allocationRepository;
	
	

	// Create
	//<S extends T> S save(S entity);
	@Test
	void testCreate () {
		
		Course course = new Course();
		course.setId(1L);
		Professor professor = new Professor();
		professor.setId(1L);		
		
		Allocation allocation = new Allocation();
		allocation.setId(1L);
		allocation.setDayOfWeek(DayOfWeek.MONDAY);
		// Isso da errado pq na definição que vc colocou foi nullable = false
		// Usa SimpleDateFormat para criar as horas:
		//SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		//Date setStart = sdf.parse("20:00");
		allocation.setStart(null);
		allocation.setEnd(null); 
		
		allocationRepository.save(allocation);
		System.out.println(allocation);
	
		}
	
		@Test
		void test1() {
					//FindAll Red (CRUD)
			
			List<Allocation> allocations = allocationRepository.findAll();
			System.out.println(allocations);
			
		}
		
	//Read
	@Test
	void test2() {
				//Find byID (CRUD)
		Long id = 1L;	
		
		Optional<Allocation> optional= allocationRepository.findById(id);
		
		Allocation allocation = optional.orElse(null);

}
	
	
	//• Update
	//<S extends T> S save(S entity);
	
	@Test
	void save_update() {
		
	Course course = new Course();
	course.setId(1L);
	Professor professor = new Professor();
	professor.setId(1L);
	
	Allocation allocation = new Allocation();
	allocation.setId(1L);
	allocation.setDayOfWeek(DayOfWeek.MONDAY);
	allocation.setStart(null);
	allocation.setEnd(null);
	
		// Act
			allocation = allocationRepository.save(allocation);
				
	// Print
				System.out.println("Novo professor: " + allocation);
	}
	
	
	//• Delete
	//void deleteById(ID id);
	@Test
	public void deleteById() {
	// Arrange
	Long id = 1L;

	// Act
	allocationRepository.deleteById(id);
	}

		
		
		
	
	
	

}
