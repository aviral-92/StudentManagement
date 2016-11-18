package com.student.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.student.dao.TeacherDao;
import com.student.pojo.TeacherDetails;

@Component
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String addTeacher(TeacherDetails teacherDetails) {

		String response = null;
		Object args[] = { teacherDetails.getTeacher_id(),
				teacherDetails.getTeacher_name(),
				teacherDetails.getTeacher_address() };
		int num = jdbcTemplate
				.update("INSERT INTO student_mgmt.teacher(TEACHER_ID,TEACHER_NAME,TEACHER_ADDRESS) values(?,?,?)",
						args);
		if (num > 0) {
			response = "Successfully Inserted data of Teacher and Teacher ID is : "
					+ teacherDetails.getTeacher_id();
		} else {
			response = "No data Inserted.";
		}
		return response;
	}
}
