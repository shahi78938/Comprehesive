package com.spring.backend.Hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.Hospital.modal.Doctor;
import com.spring.backend.Hospital.modal.Patient;
import com.spring.backend.Hospital.repository.PatientRepository;

@Service
public class PatientService implements iPatientService{

	@Autowired
	public PatientRepository pRepo;
	
	@Override
	public Patient addPatient(Patient patient) {
		return pRepo.save(patient);
	}

	@Override
	public List<Patient> getPatients() {
		List<Patient> patients = pRepo.findAll();
		for (Patient patient : patients) {
			Doctor doctor = getDoctorByPatientId(patient.getId());
			patient.setDoctor(doctor);
		}
		return patients;
	}

	@Override
	public Patient getpatientsid(Long id) {
		return pRepo.findById(id).orElse(null);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		Patient p=pRepo.findById(patient.getId()).orElse(null);
		return pRepo.save(p);
	}

	@Override
	public String deletePatientById(Long id) {
		pRepo.deleteById(id);
		return "deleted";
	}

	public Doctor getDoctorByPatientId(Long patientid) {
		Patient p= pRepo.findById(patientid).orElse(null);
		return p.getDoctor();
	}
	
	public List<Patient> getPatientsWithOutPrescription(Long docId)
	{
		return pRepo.findPatientsWithoutPrescription(docId);
	}
	
	

	

}
