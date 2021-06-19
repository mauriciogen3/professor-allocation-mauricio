package com.project.professor.allocation.entity;
import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity // representa uma classe
public class Allocation {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // da o poder de um auto incrementada
	private Long id;
	
	@Enumerated(value = EnumType.STRING) // como armazenar uma informacao no banco de dados valor armazenado ( textou ou numero) String para informar que é texto
	@Column(nullable = false, unique = false) // configura a mais sua coluna
	private DayOfWeek dayOfWeek;
	
	@Temporal(value = TemporalType.TIME)
	@Column(nullable = false, unique = false)
	private Date start;
	
	@Temporal(value = TemporalType.TIME)
	@Column(nullable = false, unique = false)	
	private Date end;
	
	//copiado e colado manytoone
	@ManyToOne(optional = false)
	@JoinColumn(name = "professor_id", nullable = false)
	private Professor professor;

	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;
	
	public Allocation() {
		super();
	}

	public Allocation(Long id, DayOfWeek dayOfWeek, Date start, Date end) {
		super();
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.start = start;
		this.end = end;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	

}
