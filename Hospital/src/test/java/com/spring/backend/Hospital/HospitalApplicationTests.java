package com.spring.backend.Hospital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.backend.Hospital.modal.Doctor;
import com.spring.backend.Hospital.repository.DoctorRepository;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class HospitalApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@Autowired
	DoctorRepository dRepo;
	
	@Test
	@Order(1)
	public void testCreate() {
		Doctor c=new Doctor();
		c.setName("poornima");
		c.setAge(45);
		c.setSpeciality("EAR");
		c.setPatientsCount(0);
		dRepo.save(c);
		assertNotNull(dRepo.findById(3L).get());
	}
	
	@Test
	@Order(2)
	public void testbyId()
	{
		Doctor c = dRepo.findById(3L).get();
		assertEquals("poornima", c.getName());	
	}
	
	@Test
	@Order(3)
	public void testAll()
	{
		List<Doctor> list = dRepo.findAll();
		assertTrue(list.size()==3);	
	}
	
	@Test
	@Order(4)
	public void testUpdate()
	{
		Doctor e= dRepo.findById(3L).get();
		e.setName("geethika");
		dRepo.save(e);
		assertNotEquals("poornima",dRepo.findById(3L).get().getName());
	}

	@Test
	@Order(5)
	public void testDelete()
	{
		dRepo.deleteById(3L);
		assertFalse(dRepo.existsById(3L));
	}
}
