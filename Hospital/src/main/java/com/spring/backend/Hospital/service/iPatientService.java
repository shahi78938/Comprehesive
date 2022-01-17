package com.spring.backend.Hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.backend.Hospital.modal.Patient;


@Service
public interface iPatientService {
	
	public Patient addPatient(Patient patient);

	public List<Patient> getPatients();

	public Patient getpatientsid(Long id);
	
	public List<Patient> getPatientsWithOutPrescription(Long docId);
	
	public Patient updatePatient(Patient patient);

	public String deletePatientById(Long id);
}
