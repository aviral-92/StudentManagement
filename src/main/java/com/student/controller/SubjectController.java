package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dao.SubjectDao;
import com.student.pojo.SubjectDetails;

@RestController
@RequestMapping("subject")
public class SubjectController {

	@Autowired
	private SubjectDao subjectDao;

	@RequestMapping("/addsubject")
	public String addsuibjectDetails() {
		SubjectDetails subjectDetails = new SubjectDetails(101, "Java", "99");
		return subjectDao.addSubject(subjectDetails);
	}

	@RequestMapping("/getsubject")
	public List<SubjectDetails> getSubject(SubjectDetails subjectDetails) {
		SubjectDetails subjectDetail = new SubjectDetails(101, "Java", "99");
		List<SubjectDetails> response = subjectDao.getSubject(subjectDetail);
		System.out.println(">>>>>>>>>>>>>>>>>>>>" + response);
		return response;

	}
}
