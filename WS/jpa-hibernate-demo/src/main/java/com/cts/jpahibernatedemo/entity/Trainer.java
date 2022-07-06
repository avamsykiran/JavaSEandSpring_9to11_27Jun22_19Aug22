package com.cts.jpahibernatedemo.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity

/*@Table(name="all_trainers")
 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
 * @DiscriminatorColumn(name = "trainer_type",discriminatorType = DiscriminatorType.STRING)
 * @DiscriminatorValue("trainer")
*/

/*@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="trainers")*/

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="trainers_only")
public class Trainer {

	@Id
	private Long traienrId;
	private String fullName;
	@Embedded
	private Address address;
	private String skill;
	private Double salary;
	
	public Trainer() {
		// TODO Auto-generated constructor stub
	}

	public Trainer(Long traienrId, String fullName, Address address, String skill,Double salary) {
		super();
		this.traienrId = traienrId;
		this.fullName = fullName;
		this.address = address;
		this.skill = skill;
		this.salary=salary;
	}

	public Long getTraienrId() {
		return traienrId;
	}

	public void setTraienrId(Long traienrId) {
		this.traienrId = traienrId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	
	
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Trainer [traienrId=" + traienrId + ", fullName=" + fullName + ", address=" + address + ", skill="
				+ skill + "]";
	}
	
	
}
