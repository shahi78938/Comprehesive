package com.spring.backend.Hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.backend.Hospital.modal.Doctor;
import com.spring.backend.Hospital.modal.Patient;


@Service
public interface iDoctorService {
	
	public Doctor addDoctor(Doctor doctor);

	public List<Doctor> getDoctors();

	public Doctor getdoctorsid(Long id);
	
	public Doctor updateDoctor(Doctor doctor,Long id);

	public String deleteDoctorById(Long doctorId);

	public List<Patient> getPatientsByDoctorId(Long doctorId);

}
