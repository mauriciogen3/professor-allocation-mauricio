package com.project.professor.allocation.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.service.AllocationService;

@RestController
@RequestMapping(path = "/allocations", produces = MediaType.APPLICATION_JSON_VALUE)
public class AllocationController {
	private final AllocationService allocationService;

	
	public AllocationController(AllocationService allocationService) {
		super();
		this.allocationService = allocationService;
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Allocation>> findAll(){
		List<Allocation> allocations = allocationService.findAll();
		return new ResponseEntity<> (allocations, HttpStatus.OK);
	}
	@GetMapping(path = "/{allocation_id")
	public ResponseEntity<Allocation> findById(@PathVariable (name = "allocation_id") Long id ){
		Allocation allocation = allocationService.findById(id);
		if(allocation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(allocation, HttpStatus.OK);
		}
	}
	
	 
	

}
