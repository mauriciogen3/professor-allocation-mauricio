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
import com.project.professor.allocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	@Autowired
	private ProfessorRepository professorRepository;

	// Create
	// <S extends T> S save(S entity);
	@Test
	// Primeiro se cria o departamento, depois o professor
	void testCreate() {

		Department department = new Department();
		department.setId(1L);

		Professor professor = new Professor();
		professor.setId(1L);
		professor.setName("Maurício");
		professor.setCpf("111.111.111-11");
		professor.setDepartment(department);

		// Act
		professor = professorRepository.save(professor);

		// print
		System.out.println(professor);
	}

	// Read
	@Test
	void testRead() {
		// Find byID (CRUD)
		Long id = 1L;

		// Act
		List<Professor> professor = professorRepository.findAll();
		Optional<Professor> professorId = professorRepository.findById(id);

		// Print
		System.out.println("-------------");
		System.out.println(professorId.orElse(null));
		System.out.println("-------------");
		System.out.println(professor);

	}

	@Test
	public void testUpdate() {
		Department department = new Department();
		department.setId(1L);

		Professor professor = professorRepository.getById(1L);
		professor.setName("João");
		professor.setCpf("222.222.222-22");
		professor.setDepartment(department);

		// Act
		professor = professorRepository.save(professor);

		// Print
		System.out.println(professor);
	}

	// • Delete
	// void deleteById(ID id);
	@Test
	public void deleteById() {

		// Arrange
		Long id = 2L;

		// Act
		professorRepository.deleteById(id);
	}

}
