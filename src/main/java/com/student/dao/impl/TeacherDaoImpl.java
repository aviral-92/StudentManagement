package com.student.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.student.dao.TeacherDao;
import com.student.dao.impl.extractor.TeacherExtractor;
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

	public List<TeacherDetails> getTeacher(TeacherDetails teacherDetails) {
		String query = "SELECT * FROM STUDENT_MGMT.TEACHER";
		List<TeacherDetails> response = jdbcTemplate.query(query,
				new TeacherExtractor());
		return response;
	}

	public String updateteacher(TeacherDetails teacherDetails) {
		String response = null;
		Object args[] = { teacherDetails.getTeacher_id(),
				teacherDetails.getTeacher_name(),
				teacherDetails.getTeacher_address() };
		int num=jdbcTemplate.update(" Update student_mgmt TEACHER_ID = ?, TEACHER_NAME = ?, TEACHER_ADDRESS = ? where TEACHER_ID = ?", args);
		if(num>0){
			response = "Successfully Updated data of Teacher and Teacher ID is : "
					+ teacherDetails.getTeacher_id();
		} else {
			response = "No data Updated.";
		}
		return response;
	}
}
