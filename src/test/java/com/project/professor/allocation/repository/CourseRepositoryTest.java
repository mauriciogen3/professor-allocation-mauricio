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

import com.project.professor.allocation.entity.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void testCreate(){
		
		//Arrange
		Course course = new Course();
		course.setName("bina");
		
		// Act
		course = courseRepository.save(course);
		
		// Print
		System.out.println(course);
	}
	
	@Test
	public void testRead(){
		
		//Arrange
		Long id = 1L;
				
		// Act
		List<Course> course = courseRepository.findAll();
		Optional<Course> courseByID = courseRepository.findById(id);
		
		// Print
		System.out.println("-------------");
		System.out.println(courseByID);
		System.out.println("-------------");
		System.out.println(course);
	}
	
	@Test
	public void testUpdate(){
		
		//Arrange
		Course course = new Course();
		course.setId(1L);
		course.setName("Matemática");
		
		// Act
		course = courseRepository.save(course);
		
		// Print
		System.out.println(course);
	}
	
	@Test
	public void testDeleteById(){
		
		//Arrange
		Long id = 1L;
		
		// Act
		courseRepository.deleteById(id);
	
	}
	
	@Test
	public void testDeleteAll(){
		
		// Act
		courseRepository.deleteAll();
	
	}
}
