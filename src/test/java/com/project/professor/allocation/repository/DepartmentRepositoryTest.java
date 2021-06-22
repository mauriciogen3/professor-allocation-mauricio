package com.project.professor.allocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Test
	public void testCreate(){
		
		//Arrange
		Department department = new Department();
		department.setName("corrida");
		
		// Act
		department = departmentRepository.save(department);
		
		// Print
		System.out.println(department);
	}
	
	@Test
	public void testRead(){
		
		//Arrange
		Long id = 4L;
				
		// Act
		List<Department> department = departmentRepository.findAll();
		Optional<Department> departmentByID = departmentRepository.findById(id);
		
		// Print
		System.out.println("-------------");
		System.out.println(departmentByID);
		System.out.println("-------------");
		System.out.println(department);
	}
	
	@Test
	public void save_update(){
		
		//Arrange
		Department department = new Department();
		department.setId(1L);
		department.setName("Historia");
		
		// Act
		department = departmentRepository.save(department);
		
		// Print
		System.out.println(department);
	}
	
	@Test
	
	
	public void deleteById() {
		// Arrange
		Long id = 1L;
		
		// Act
		departmentRepository.deleteById(id);
		}
}
