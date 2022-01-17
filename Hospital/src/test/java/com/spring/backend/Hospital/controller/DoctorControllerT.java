package com.spring.backend.Hospital.controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.backend.Hospital.modal.Doctor;
import com.spring.backend.Hospital.modal.Patient;
import com.spring.backend.Hospital.service.DoctorService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DoctorController.class)
@WithMockUser
public class DoctorControllerT {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DoctorService doctorService;

	Doctor mockCourse = new Doctor("shahi",20,"ENT",0);
	
	String exampleCourseJson = "[{\"name\":\"d1\",\"age\":15,\"speciality\":\"ENT\"}]";
	//{"id":1,"name":"p1","age":15,"dateofVisit":"2000-12-05"}

	@Test
	public void retirveDoctor() throws Exception {

		Mockito.when(
				doctorService.getdoctorsid(Mockito.anyLong())).thenReturn(mockCourse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/Doctors/3").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"name\":\"shahi\",\"age\":20,\"speciality\":\"ENT\",\"patientsCount\":0}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void createDoctorTest() throws Exception {
		Doctor mockCourse = new Doctor("shahi",20,"EAR",0);
		Mockito.when(
				doctorService.addDoctor(Mockito.any(Doctor.class))).thenReturn(mockCourse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/addDoctor")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void upDateDoctor() throws Exception {
		Doctor mockCourse = new Doctor("shahi",25,"EAR",5);
		Mockito.when(
				doctorService.updateDoctor(Mockito.any(Doctor.class),Mockito.anyLong())).thenReturn(mockCourse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/updateDoctor/1")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String expected = "{\"name\":\"shahi\",\"age\":25,\"speciality\":\"ENT\",\"patientsCount\":5}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

	
	
}
