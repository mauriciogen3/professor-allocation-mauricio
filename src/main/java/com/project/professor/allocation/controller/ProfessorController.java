package com.project.professor.allocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.service.ProfessorService;

@RestController
@RequestMapping (path = "/professors", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfessorController {
	
	private final ProfessorService professorService;
	
	public ProfessorController (ProfessorService professorService) {
		this.professorService = professorService;
	}
//@GetMapping
	@GetMapping(path = "/") //GET / professors
	public ResponseEntity<List<Professor>> findAll() {
		List<Professor> professors = professorService.findAll();
		return new ResponseEntity<> (professors, HttpStatus.OK);
	}
	@GetMapping(path = "/{professor_id") //GET / professors/1
	public ResponseEntity<Professor> findById(@PathVariable (name = "professor_id") Long id) {
		Professor professor = professorService.findById(id);
		if(professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			return new ResponseEntity<>(professor, HttpStatus.OK);
		}
	}
}
