package com.spring.backend.Hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.Hospital.modal.Doctor;
import com.spring.backend.Hospital.modal.Patient;
import com.spring.backend.Hospital.repository.DoctorRepository;
import com.spring.backend.Hospital.repository.PatientRepository;

@Service
public class DoctorService implements iDoctorService {

	@Autowired
	public DoctorRepository dRepo;

	@Autowired
	public PatientRepository pRepo;
	
	@Override
	public Doctor addDoctor(Doctor doctor) {
		return dRepo.save(doctor);
	}

	@Override
	public List<Doctor> getDoctors()
	{
		List<Doctor> doctors = dRepo.findAll();
		for (Doctor doctor : doctors) {
			int patientCountByDoctorId = getPatientCountByDoctorId(doctor.getId());
			doctor.setPatientsCount(patientCountByDoctorId);
		}
		return doctors;
	}

	public int getPatientCountByDoctorId(Long id) {
		return dRepo.getPatientCountByDoctorId(id);
	}

	@Override
	public Doctor getdoctorsid(Long id) {
		Doctor doctor=dRepo.findById(id).orElse(null);
		int patientCountByDoctorId = getPatientCountByDoctorId(doctor.getId());
		doctor.setPatientsCount(patientCountByDoctorId);
		return doctor;
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, Long id) {
		Doctor d = dRepo.findById(id).orElse(null);
		d.setAge(doctor.getAge());
		d.setName(doctor.getName());
		d.setPatientsCount(getPatientCountByDoctorId(doctor.getId()));
		return dRepo.save(d);
	}

	@Override
	public String deleteDoctorById(Long doctorId) {
		List<Patient> list = getPatientsByDoctorId(doctorId);
		for (Patient list1 : list) {
			list1.setDoctor(null);
		}
		pRepo.deleteById(doctorId);
		return "deleted";
	}

	@Override
	public List<Patient> getPatientsByDoctorId(Long doctorId) {
		List<Patient> patients = pRepo.findAll();
		List<Patient> patientsList = new ArrayList<Patient>();
		for (Patient p : patients) {
			if (p.getDoctor().getId() == doctorId) {
				patientsList.add(p);
			}
		}
		return patientsList;
	}
	
	
}
