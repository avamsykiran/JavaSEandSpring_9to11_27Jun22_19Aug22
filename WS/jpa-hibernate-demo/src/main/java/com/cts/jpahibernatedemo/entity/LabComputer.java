package com.cts.jpahibernatedemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="lab_computers")
public class LabComputer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assetId;
	private String computerConfig;
	
	@OneToOne
	@JoinColumn
	private Trainee owner;
	
	public LabComputer() {
		// TODO Auto-generated constructor stub
	}

	public LabComputer(Long assetId, String computerConfig, Trainee owner) {
		super();
		this.assetId = assetId;
		this.computerConfig = computerConfig;
		this.owner = owner;
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getComputerConfig() {
		return computerConfig;
	}

	public void setComputerConfig(String computerConfig) {
		this.computerConfig = computerConfig;
	}

	public Trainee getOwner() {
		return owner;
	}

	public void setOwner(Trainee owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "LabComputer [assetId=" + assetId + ", computerConfig=" + computerConfig + ", owner=" + owner + "]";
	}
	
	
}
