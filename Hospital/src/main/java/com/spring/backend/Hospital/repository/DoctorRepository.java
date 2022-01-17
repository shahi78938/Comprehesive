package com.spring.backend.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.backend.Hospital.modal.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long>{

	@Query(value="select count(*) from patient p inner join doctor d on p.doctor_id = d.id"
			+ " where d.id = ?#{[0]}",nativeQuery = true)
	int getPatientCountByDoctorId(Long doctorId);

}
