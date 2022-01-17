package com.spring.backend.Hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.spring.backend.Hospital.service.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

	@Autowired
	public DoctorService dService;

	@GetMapping("/Doctors")
	public List<Doctor> FindDoctors() {
		return dService.getDoctors();
	}

	@GetMapping("/Doctors/{id}")
	public Doctor findDoctorById(@PathVariable Long id) {
		return dService.getdoctorsid(id);
	}

	@GetMapping("/Doctors/{id}/patients")
	public List<Patient> findpatients(@PathVariable Long id) {
		return dService.getPatientsByDoctorId(id);
	}
	@PostMapping("/addDoctor")
	public Long addDoctor(@RequestBody Doctor doctor) {
		dService.addDoctor(doctor);
		return doctor.getId();
	}

	@PutMapping("/updateDoctor/{id}")
	public ResponseEntity<?> updateDoctor(@RequestBody Doctor doctor, @PathVariable Long id) {
		Doctor doc = dService.updateDoctor(doctor, id);
		return new ResponseEntity<>(doc, HttpStatus.OK);
	}

	@DeleteMapping("/Doctors/{id}")
	public String DeleteDoctor(@PathVariable Long id) {
		return dService.deleteDoctorById(id);
	}

}
