package com.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.student.dao.TeacherDao;
import com.student.pojo.TeacherDetails;

@RestController
@RequestMapping("teacher")
public class TeacherContoller {

	@Autowired
	private TeacherDao teacherDao;

	@RequestMapping("/firstpage")
	public ModelAndView firstPage() {

		return new ModelAndView("addTeacher");
	}

	@RequestMapping("/addteacher")
	public String teacherDetails(ModelMap modelMap, HttpServletRequest request) {

		int id = 0;
		String name = null, address = null;
		TeacherDetails teacherDetails = null;
		if (!StringUtils.isEmpty(request.getParameter("Id"))) {
			id = Integer.parseInt(request.getParameter("Id"));
		}
		if (!StringUtils.isEmpty(request.getParameter("name"))) {
			name = (String) request.getParameter("name");
		}
		if (!StringUtils.isEmpty(request.getParameter("address"))) {
			address = (String) request.getParameter("address");
		}
		if (id > 0 && name != null && address != null) {
			teacherDetails = new TeacherDetails(id, name, address);
			return teacherDao.addTeacher(teacherDetails);
		} else {
			return "Please provide name and address to add Teacher....!!!!";
		}

	}

	@RequestMapping("/getteacher")
	public List<TeacherDetails> getTeacherDetails() {
		TeacherDetails teacherDetails = new TeacherDetails(1, "avi",
				"shastri nagar");
		return teacherDao.getTeacher(teacherDetails);
	}

	@RequestMapping("/updateteacher")
	public String updateTeacherDetails() {
		TeacherDetails teacherDetails = new TeacherDetails(2, "aviral",
				"shastri_nagar");
		return teacherDao.updateteacher(teacherDetails);
	}

	@RequestMapping("/deleteteacher")
	public String deleteTeacher() {
		TeacherDetails teacherDetails = new TeacherDetails(1, "avi",
				"shastri nagar");
		return teacherDao.deleteTeacher(teacherDetails);

	}
}
