package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.DepartmentRepository;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service //diz ao spring que é uma classe de serviços por meio da anotação @Sercice
public class ProfessorService {
	private final ProfessorRepository profRepository;
	private final DepartmentRepository departmentRepository;

	public ProfessorService(ProfessorRepository profRepository, DepartmentRepository departmentRepository) {
		super();
		this.profRepository = profRepository;
		this.departmentRepository = departmentRepository;
	}
/*tudo isso que foi feito acima foi apenas a casca do projeto, importou a classe de servicos
 * através da anotação, criei uma instancia do meu repositorio atraves do private ProfessorRepository
 * criou um atributo (profRepository). Importamos o repositorio e agora vamos ensinar o spring
 * a criar um new dessa classe de servicos.
 * Fomos em source, genereted construtor e ele gerou o construtor. acabando a casca da camada de 
 * servicos.
 */
	// controle pede todos os professores a professor Serviice
	
	
	//FIND ALL
public List <Professor> findAll(){
	
	List <Professor> professors = profRepository.findAll();
	return professors;	
}
	//FIND BY ID
public Professor findById(Long id){ 
	Optional<Professor> optional = profRepository.findById(id);
	Professor p = optional.orElse(null);
	return p;
	}

	//CREATE//
public Professor create (Professor professor){
professor.setId(null);
Professor newProfessor = profRepository.save(professor);

// Usar saveInternal
Long departmentId = newProfessor.getDepartment().getId();
Department newDepartment = departmentRepository.findById(departmentId).orElse(null);
newProfessor.setDepartment(newDepartment);
return newProfessor;
}

	//UPDATE

public Professor update(Professor professor) {
	
	boolean exists = profRepository.existsById(professor.getId());
	if(exists) {
		/*Professor newProfessor = profRepository.save(professor);

		Long departmentId = newProfessor.getDepartment().getId();
		Department newDepartment = departmentRepository.findById(departmentId).orElse(null);
		newProfessor.setDepartment(newDepartment);*/
		
		//-----------------------------------------------------------------------------------------------------------//
		//Professor newProfessor = saveInternal(professor); // o código acima foi substituido pelo privateProfessor save Internal abaixo.
		// return newProfessor; Desse modo está correto, porém o metodo mais indicado seria
		//-----------------------------------------------------------------------------------------------------------//
		return saveInternal(professor);
	} else {
		return null;
	}
	
}

private Professor saveInternal(Professor professor) {
	Professor newProfessor = profRepository.save(professor);

	Long departmentId = newProfessor.getDepartment().getId();
	Department newDepartment = departmentRepository.findById(departmentId).orElse(null);
	newProfessor.setDepartment(newDepartment);
	return newProfessor;
	
}

		//DELETE

public void delete(Long professorId) { // delete é void pois nao retorna nada.
	boolean exists = profRepository.existsById(professorId);
	if(exists) {
		departmentRepository.deleteById(professorId);
	}
	
	//public void deleteAll() {
	//	profRepository.deleteAllInBatch();	
	//MESMO ERRO. O UNICO QUE NAO APRESENTOU ESSE ERRO FOI DEPARTMENTSERVICE
	// Mais uma vez a mesma correção. Mais uma vez está faltando indentação nas classes. Esse
	// problema seria evitado se as classes estivessem com indentação (Ctrl + Shift + F).
		
}
}
