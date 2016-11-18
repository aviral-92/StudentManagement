package com.student.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.pojo.StudentDetail;

@RestController
@RequestMapping("student")
public class StudentController {

	@RequestMapping("/student")
	public String test() {

		return "Hello Mahima Agrawal";
	}

	@RequestMapping("/studentobject")
	public StudentDetail student() {

		StudentDetail studentDetail = new StudentDetail(1, "Mahima Agrawal",
				"Shastri Nagar", "BCA Final Year");
		return studentDetail;
	}

	@RequestMapping(value = "/studentobjectxml", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public StudentDetail studentXML() {

		StudentDetail studentDetail = new StudentDetail(1, "Mahima Agrawal",
				"Shastri Nagar", "BCA Final Year");
		return studentDetail;
	}
}
