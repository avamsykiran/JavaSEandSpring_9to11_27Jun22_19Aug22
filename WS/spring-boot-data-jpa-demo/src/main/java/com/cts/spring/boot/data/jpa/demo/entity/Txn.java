package com.cts.spring.boot.data.jpa.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="txns")
public class Txn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long txnId;
	private String description;
	private Double amount;
	private LocalDate txnDate;
	@Enumerated(EnumType.STRING)
	private TxnType type;
	
	public Txn() {
		// TODO Auto-generated constructor stub
	}

	public Txn(Long txnId, String description, Double amount, LocalDate txnDate, TxnType type) {
		super();
		this.txnId = txnId;
		this.description = description;
		this.amount = amount;
		this.txnDate = txnDate;
		this.type = type;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(LocalDate txnDate) {
		this.txnDate = txnDate;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((txnDate == null) ? 0 : txnDate.hashCode());
		result = prime * result + ((txnId == null) ? 0 : txnId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Txn other = (Txn) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (txnDate == null) {
			if (other.txnDate != null)
				return false;
		} else if (!txnDate.equals(other.txnDate))
			return false;
		if (txnId == null) {
			if (other.txnId != null)
				return false;
		} else if (!txnId.equals(other.txnId))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Txn [txnId=" + txnId + ", description=" + description + ", amount=" + amount + ", txnDate=" + txnDate
				+ ", type=" + type + "]";
	}
	
	
}
