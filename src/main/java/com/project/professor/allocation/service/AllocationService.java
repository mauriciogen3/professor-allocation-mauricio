package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.AllocationRepository;

@Service
public class AllocationService {
	private final AllocationRepository allocRepository;
	// private final ProfessorService professorService;
	// private final CourseService courseService;

	public AllocationService(AllocationRepository allocRepository) {
		super();
		this.allocRepository = allocRepository;
	}

	// FIND BY ID
	public Allocation findById(Long id) {
		// return allocRepository.findById(id).orElse(null); poderia ser assim tambem,
		// como no slide!! :D
		Optional<Allocation> optional = allocRepository.findById(id);
		Allocation a = optional.orElse(null);
		return a;
	}

	// FIND ALL
	public List<Allocation> findAll() {
		List<Allocation> allocation = allocRepository.findAll();
		return allocation;

	}

	// CREATE
	public Allocation Create(Allocation allocation) {
		allocation.setId(null);
		return allocation;

	}

	// UPDATE
	public Allocation update(Allocation allocation) {
		boolean exists = allocRepository.existsById(allocation.getId());
		if (exists) {
			return allocation;
		} else {
			return null;
		}

	}

	// DELETE
	public void deleteById(Long AllocationId) {
		//if (id !=null && allocRepository.existsById(id)) {
		//allocRepository.deleteById(id); }
		//NO SLIDE ESTAVA COMO NO MODELO COMENTADO ACIMA, ALTEREI COMO BASE O QUE FOI VISTO NA AULA.
		boolean exists = allocRepository.existsById(AllocationId);
		if(exists) {
			allocRepository.deleteById(AllocationId);
		
		}
		
		//DELETE ALL
		//public void deleteAll() {
	//		allocRepository.deleteAllInBatch();
		
		// O CÓDIGO DO DELETE ALL ESTÁ APRESENTANDO ERRO DE SINTAXE. MAS ONDE?
		}
		}

