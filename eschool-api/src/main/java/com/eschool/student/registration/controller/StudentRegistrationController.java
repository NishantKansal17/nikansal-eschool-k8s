package com.eschool.student.registration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eschool.student.modal.Student;
import com.eschool.student.response.Response;


@Controller
@RequestMapping(value="/eschool/student/registration")
public class StudentRegistrationController {

	private static List<Student> students = new ArrayList<Student>();
	
	@RequestMapping(value="/create", 
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Response doRegistration (@RequestBody Student student) {
		Response response = new Response();
		if (student.getEmail() == null
				|| "".equals(student.getEmail())) {
			response.setStatus("failure");
			response.setCode("500");
			response.setMessage("Email is mandatory.");
			return response;
		}
		student.setId(UUID.randomUUID().toString());
		students.add(student);
		response.setStatus("success");
		response.setCode("200");
		response.setMessage("Student registered successfully!");
		return response;
	}
	
	@RequestMapping(value="/findAllStudents", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Student> getAllStudents () {
		return students;
	}
}
