package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.AllocationRepository;
import com.project.professor.allocation.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
	//FIND ALL
    public List<Department> findAll(String name) {
        if (name == null) {
            return departmentRepository.findAll();
        } else {
            return departmentRepository.findByNameContainingIgnoreCase(name);
        }
	}
	
	//FIND BY ID
	public Department findById(Long id){ 
		Optional<Department> optional = departmentRepository.findById(id);
		Department d = optional.orElse(null);
		return d;
		}

		//CREATE//
	//public Professor create (Department department){
	//	Department.setId(null);
	//	return department;
    public Department save(Department department) {
        department.setId(null);
        return saveInternal(department);
    }

		//UPDATE
    public Department update(Department department) {
        Long id = department.getId();
        if (id == null || !departmentRepository.existsById(id)) {
           // throw getEntityInstanceNotFoundExceptionSupplier(id).get();
        	//ESSE CÓDIGO NAO ENTENDI SUA USUABILIDADE, TANTO É QUE ESTA DANDO ERRO NO CODIGO.
        }

        return saveInternal(department);
    }


	
			//DELETE

	public void delete(Long id) { // delete é void pois nao retorna nada.
		if (id!= null && departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		}
		
	}
	
	public void deleteAll() {
		departmentRepository.deleteAllInBatch();	
		}
	

    private Department saveInternal(Department department) {
        return departmentRepository.save(department);
}
    
    
}
