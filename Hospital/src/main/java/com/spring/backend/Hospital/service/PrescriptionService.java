package com.spring.backend.Hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.Hospital.modal.Prescription;
import com.spring.backend.Hospital.repository.PrescriptionRepository;

@Service
public class PrescriptionService {
	
	@Autowired
	PrescriptionRepository presRepo;
	
	public Prescription addPrescription(Prescription pres)
	{
		return presRepo.save(pres);
	}
	
	public Prescription getPrescriptionByPatientId(Long id)
	{
		return presRepo.findPrescriptionByPatientId(id);
	}

}
