package com.cts.jpahibernatedemo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long crId;
	private String crName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "course")
	private Set<Trainee> trainees;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(Long crId, String crName) {
		super();
		this.crId = crId;
		this.crName = crName;
	}

	public Course(Long crId, String crName, Set<Trainee> trainees) {
		super();
		this.crId = crId;
		this.crName = crName;
		this.trainees = trainees;
	}

	public Long getCrId() {
		return crId;
	}

	public void setCrId(Long crId) {
		this.crId = crId;
	}

	public String getCrName() {
		return crName;
	}

	public void setCrName(String crName) {
		this.crName = crName;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}

	@Override
	public String toString() {
		return "Course [crId=" + crId + ", crName=" + crName + "]";
	}
	
	
	
}
