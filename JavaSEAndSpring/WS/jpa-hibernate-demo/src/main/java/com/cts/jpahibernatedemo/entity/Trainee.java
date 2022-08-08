package com.cts.jpahibernatedemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trainees")
public class Trainee implements Comparable<Trainee> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long traineeId;
	private String fullName;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Embedded
	private Address address;
	
	@OneToOne(mappedBy = "owner",cascade = CascadeType.ALL)
	private LabComputer computer;
	
	@ManyToOne
	private Course course;
	
	public Trainee() {
		// TODO Auto-generated constructor stub
	}

	public Trainee(Long traineeId, String fullName, Gender gender, Address address, LabComputer computer,
			Course course) {
		super();
		this.traineeId = traineeId;
		this.fullName = fullName;
		this.gender = gender;
		this.address = address;
		this.computer = computer;
		this.course = course;
	}

	public Long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LabComputer getComputer() {
		return computer;
	}

	public void setComputer(LabComputer computer) {
		this.computer = computer;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", fullName=" + fullName + ", gender=" + gender + ", address="
				+ address + ", computer=" + computer + ", course=" + course + "]";
	}

	@Override
	public int compareTo(Trainee o) {
		return this.traineeId==null? -1: this.traineeId.compareTo(o.traineeId);
	}
	
	
}
