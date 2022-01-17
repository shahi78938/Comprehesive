package com.spring.backend.Hospital.modal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	private String dateofVisit;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "doctor_id", nullable = false)
	private Doctor doctor;
	
	protected Patient() {

	}

	public Patient(String name, int age, String dateofVisit) {
		super();
		this.name = name;
		this.age = age;
		this.dateofVisit = dateofVisit;
	}

	public Patient(String name, int age, String dateofVisit, Doctor doctor) {
		super();
		this.name = name;
		this.age = age;
		this.dateofVisit = dateofVisit;
		this.doctor = doctor;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateofVisit() {
		return dateofVisit;
	}

	public void setDateofVisit(String dateofVisit) {
		this.dateofVisit = dateofVisit;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", age=" + age + "," + " dateofVisit=" + dateofVisit + ", " + "doctor="
				+ doctor + "]";
	}

}
