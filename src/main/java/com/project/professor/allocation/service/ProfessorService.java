package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service //diz ao spring que é uma classe de serviços por meio da anotação @Sercice
public class ProfessorService {
	private final ProfessorRepository profRepository;

	public ProfessorService(ProfessorRepository profRepository) {
		super();
		this.profRepository = profRepository;
	}
/*tudo isso que foi feito acima foi apenas a casca do projeto, importou a classe de servicos
 * através da anotação, criei uma instancia do meu repositorio atraves do private ProfessorRepository
 * criou um atributo (profRepository). Importamos o repositorio e agora vamos ensinar o spring
 * a criar um new dessa classe de servicos.
 * Fomos em source, genereted construtor e ele gerou o construtor. acabando a casca da camada de 
 * servicos.
 */
	// controle pede todos os professores a professor Serviice
	
public List <Professor> findAll(){
	
	List <Professor> professors = profRepository.findAll();
	return professors;	
}

public Professor findById(Long id){ 
	Optional<Professor> optional = profRepository.findById(id);
	Professor p = optional.orElse(null);
	return p;
	}

public Professor create (Professor professor){
professor.setId(null);
Professor newProfessor = profRepository.save(professor);
return newProfessor;
}

}
