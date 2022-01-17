package com.spring.backend.Hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend.Hospital.modal.Patient;
import com.spring.backend.Hospital.modal.Prescription;
import com.spring.backend.Hospital.service.PrescriptionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PrescriptionController {
	@Autowired
	public PrescriptionService pService;
	
	@PostMapping("/addPrescription")
	public Long addPrescription(@RequestBody Prescription prescription)
	{
		pService.addPrescription(prescription);
		return prescription.getId();
	}
	
	@GetMapping("/getPrescription/{patientId}")
	public Prescription getPrescriptionByPatientId(@PathVariable Long patientId)
	{
		return pService.getPrescriptionByPatientId(patientId);
	}
}
