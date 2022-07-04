package com.cts.jpahibernatedemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long crId;
	private String crName;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(Long crId, String crName) {
		super();
		this.crId = crId;
		this.crName = crName;
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

	@Override
	public String toString() {
		return "Course [crId=" + crId + ", crName=" + crName + "]";
	}
	
	
	
}
