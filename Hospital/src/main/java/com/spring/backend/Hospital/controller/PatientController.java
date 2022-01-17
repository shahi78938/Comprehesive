package com.spring.backend.Hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend.Hospital.modal.Doctor;
import com.spring.backend.Hospital.modal.Patient;
import com.spring.backend.Hospital.service.PatientService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PatientController {
	
	@Autowired
	private PatientService pService;
	
	@PostMapping("/addPatient")
	public Long addPatient(@RequestBody Patient patient)
	{
		pService.addPatient(patient);
		return patient.getId();
	}
	
	@PutMapping("/updatePatient")
	public Patient updatePatient(@RequestBody Patient patient)
	{
		return pService.updatePatient(patient);
	}
	
	@DeleteMapping("/removePatient/{id}")
	public String DeletePatient(@PathVariable Long id)
	{
		return pService.deletePatientById(id);
	}

	@GetMapping("/getPatients")
	public List<Patient> FindPatients()
	{
		return pService.getPatients();
	}
	
	@GetMapping("/getPatient/{id}")
	public Patient findPatientById(@PathVariable Long id)
	{
		return pService.getpatientsid(id);
	}
	
	@GetMapping("/patients/{Patientid}/Doctor")
	public Doctor findpatientById(@PathVariable Long Patientid)
	{
		return pService.getDoctorByPatientId(Patientid);
	}
	
	@GetMapping("/patientsWithOutPrescription/{DoctorId}")
	public List<Patient> findPatientsWithoutPrescription(@PathVariable Long DoctorId)
	{
		return pService.getPatientsWithOutPrescription(DoctorId);
	}
	
}
