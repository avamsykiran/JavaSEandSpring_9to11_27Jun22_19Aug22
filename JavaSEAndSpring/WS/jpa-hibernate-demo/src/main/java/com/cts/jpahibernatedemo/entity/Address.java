package com.cts.jpahibernatedemo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String houseDetails;
	private String city;
	private String state;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String houseDetails, String city, String state) {
		super();
		this.houseDetails = houseDetails;
		this.city = city;
		this.state = state;
	}

	public String getHouseDetails() {
		return houseDetails;
	}

	public void setHouseDetails(String houseDetails) {
		this.houseDetails = houseDetails;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
