package com.cts.jpahibernatedemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("cont_trainer")
//@Table(name="c_trainers")
@Table(name="c_trainers_only")
public class ContractTrainer extends Trainer {

	private Double duration;

	public ContractTrainer() {
		// TODO Auto-generated constructor stub
	}

	public ContractTrainer(Long traienrId, String fullName, Address address, String skill, Double salary,Double duration) {
		super(traienrId, fullName, address, skill, salary);
		this.duration=duration;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "ContractTrainer [duration=" + duration + super.toString() + "]";
	}

}
