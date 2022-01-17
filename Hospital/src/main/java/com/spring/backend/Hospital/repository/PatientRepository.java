package com.spring.backend.Hospital.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.backend.Hospital.modal.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long>{
	
	@Query(value="select pat.* from Patient pat left join prescription pre on pat.id = pre.patient_id\r\n"
			+ "where pre.id is null and pat.doctor_id=?#{[0]}",nativeQuery = true)
	List<Patient> findPatientsWithoutPrescription(Long docId);
	
}
