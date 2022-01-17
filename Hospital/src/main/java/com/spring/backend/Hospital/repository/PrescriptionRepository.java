package com.spring.backend.Hospital.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.backend.Hospital.modal.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long>{

	@Query(value="select * from Prescription where patient_id=?#{[0]}",nativeQuery = true)
	Prescription findPrescriptionByPatientId(Long id);
	
}
