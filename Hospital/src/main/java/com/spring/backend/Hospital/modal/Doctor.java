package com.spring.backend.Hospital.modal;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	private String speciality; 
	/*
	 * @OneToMany(mappedBy = "doctor",fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL)
	 * 
	 * @JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) private
	 * List<Patient> patients=new ArrayList<>();
	 */
	private int patientsCount;
	

	public Doctor()
	{
		
	}
	
	public Doctor(String name, int age, String speciality, List<Patient> patients) {
		super();
		this.name = name;
		this.age = age;
		this.speciality = speciality;
		//this.patients = patients;
	}
	
	
	
	public Doctor(String name, int age, String speciality, int patientsCount) {
		super();
		this.name = name;
		this.age = age;
		this.speciality = speciality;
		this.patientsCount = patientsCount;
	}

	public Doctor(String name, int age, String speciality) {
		super();
		this.name = name;
		this.age = age;
		this.speciality = speciality;
	}

	public Long getId()
	{
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

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getPatientsCount() {
		return patientsCount;
	}

	public void setPatientsCount(int patientsCount) {
		this.patientsCount = patientsCount;
	}

	/*
	 * @JsonManagedReference public List<Patient> getPatients() { return patients; }
	 * 
	 * public void setPatients(List<Patient> patients) { this.patients = patients; }
	 */
	@Override
	public String toString() {
		return "Doctor [name=" + name + ", "
				+ "age=" + age + ", specialities=" + 
				speciality+ "]";
	}
	
	
	
	
	
	
}
