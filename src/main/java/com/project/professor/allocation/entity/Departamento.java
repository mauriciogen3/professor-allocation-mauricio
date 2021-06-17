package com.project.professor.allocation.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String name;
		
		@Column(nullable = false, unique = false) // nao entendi se era pra colocar coluna aqui!!
		@OneToMany(mappedBy = "department")
		private List<Professor> professor;
		
		public Departamento() {
			super();
		}
		
		public Departamento (Long id, String name, List<Professor> professor) {
			super();
			this.id = id;
			this.name = name;
			this.professor = professor; 
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Professor> getProfessor() {
			return professor;
		}

		public void setProfessor(List<Professor> professor) {
			this.professor = professor;
		}
		
		

}
