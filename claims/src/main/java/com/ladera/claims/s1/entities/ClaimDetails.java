package com.ladera.claims.s1.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;


@Entity
@Data
public class ClaimDetails  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String agentId;
	
	private String customerEmailId;
	
	private String claimTicketId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate createdAt;
	@Transient
	private String conditions;
	@Transient
	public String criteria;
	@Transient
	public String value;




	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public ClaimDetails(Integer id, String agentId, String customerEmailId, String claimTicketId,
			LocalDate createdAt, String conditions) {
		super();
		this.id = id;
		this.agentId = agentId;
		this.customerEmailId = customerEmailId;
		this.claimTicketId = claimTicketId;
		this.createdAt = createdAt;
		this.conditions = conditions;
	}

	public ClaimDetails() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getClaimTicketId() {
		return claimTicketId;
	}

	public void setClaimTicketId(String claimTicketId) {
		this.claimTicketId = claimTicketId;
	}



	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ClaimDetails [id=" + id + ", agentId=" + agentId + ", customerEmailId=" + customerEmailId
				+ ", claimTicketId=" + claimTicketId + ", createdAt=" + createdAt + "]";
	}


	
	
	
	
	
	
	
	
	
}

