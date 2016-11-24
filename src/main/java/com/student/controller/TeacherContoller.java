package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dao.TeacherDao;
import com.student.pojo.TeacherDetails;

@RestController
@RequestMapping("teacher")
public class TeacherContoller {

	@Autowired
	private TeacherDao teacherDao;

	@RequestMapping("/addteacher")
	public String teacherDetails() {
		TeacherDetails teacherDetails = new TeacherDetails(2, "avi",
				"shastri nagar");
		return teacherDao.addTeacher(teacherDetails);
	}
	@RequestMapping("/getteacher")
	public List<TeacherDetails> getTeacherDetails() {
		TeacherDetails teacherDetails = new TeacherDetails(2, "avi",
				"shastri nagar");
		return teacherDao.getTeacher(teacherDetails);
	}
	@RequestMapping("/updateteacher")
	public String updateTeacherDetails() {
		TeacherDetails teacherDetails = new TeacherDetails(2, "avi",
				"shastri nagar");
		return teacherDao.updateteacher(teacherDetails);
	}
}
