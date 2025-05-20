package com.brunoleite.bloodapi.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	private double hemoglobin;
	private double leukocytes;
	private double platelets;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getHemoglobin() {
		return hemoglobin;
	}

	public void setHemoglobin(double hemoglobin) {
		this.hemoglobin = hemoglobin;
	}

	public double getLeukocytes() {
		return leukocytes;
	}

	public void setLeukocytes(double leukocytes) {
		this.leukocytes = leukocytes;
	}

	public double getPlatelets() {
		return platelets;
	}

	public void setPlatelets(double platelets) {
		this.platelets = platelets;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
