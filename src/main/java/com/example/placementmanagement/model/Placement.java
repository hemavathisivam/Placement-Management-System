package com.example.placementmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Placement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long studentId;
	private Long companyId;
	private String dateOfPlacement;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getDateOfPlacement() {
		return dateOfPlacement;
	}
	public void setDateOfPlacement(String dateOfPlacement) {
		this.dateOfPlacement = dateOfPlacement;
	}
	

}
