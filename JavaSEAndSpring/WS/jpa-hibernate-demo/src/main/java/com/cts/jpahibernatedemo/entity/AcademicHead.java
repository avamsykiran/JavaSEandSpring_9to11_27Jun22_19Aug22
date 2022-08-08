package com.cts.jpahibernatedemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("aca_head")
//@Table(name="ah_trainers")
@Table(name="ah_trainers_only")
public class AcademicHead extends Trainer {

	private Double allowence;
	
	public AcademicHead() {
		// TODO Auto-generated constructor stub
	}

	public AcademicHead(Long traienrId, String fullName, Address address, String skill, Double salary,Double allowence) {
		super(traienrId, fullName, address, skill, salary);
		this.allowence=allowence;
	}

	public Double getAllowence() {
		return allowence;
	}

	public void setAllowence(Double allowence) {
		this.allowence = allowence;
	}

	@Override
	public String toString() {
		return "AcademicHead [allowence=" + allowence + ", toString()=" + super.toString() + "]";
	}
	
	
}
