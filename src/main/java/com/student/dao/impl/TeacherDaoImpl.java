package com.student.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.student.dao.TeacherDao;
import com.student.dao.impl.extractor.TeacherExtractor;
import com.student.pojo.TeacherDetails;

@Component
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String addTeacher(TeacherDetails teacherDetails) {

		String response = null;
		if (!isTeacherExist(teacherDetails)) {
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
		} else {
			response = "TeacherId " + teacherDetails.getTeacher_id()
					+ " already exist ";
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
		Object args[] = { teacherDetails.getTeacher_name(),
				teacherDetails.getTeacher_address(),
				teacherDetails.getTeacher_id() };
		int num = jdbcTemplate
				.update("Update student_mgmt.teacher set TEACHER_NAME = ?, TEACHER_ADDRESS = ? where TEACHER_ID = ?",
						args);
		if (num > 0) {
			response = "Successfully Updated data of Teacher and Teacher ID is : "
					+ teacherDetails.getTeacher_id();
		} else {
			response = "No data Updated.";
		}
		return response;
	}

	public String deleteTeacher(TeacherDetails teacherDetails) {
		String response = null;
		Object args[] = { teacherDetails.getTeacher_id() };

		int num = jdbcTemplate
				.update("Delete from student_mgmt.teacher where  TEACHER_ID = ?;",
						args);

		if (num > 0) {
			response = "Successfully deleted data of Teacher and teacher ID is:"
					+ teacherDetails.getTeacher_id();
		} else {
			response = "No data Deleted";
		}
		return response;
	}

	private boolean isTeacherExist(TeacherDetails teacherDetails) {

		boolean result = false;
		String query = "select * from student_mgmt.teacher where teacher_id= ? ";
		Object args[] = { teacherDetails.getTeacher_id() };
		List<TeacherDetails> response = jdbcTemplate.query(query,
				new TeacherExtractor(), args);
		if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
			result = true;
		}
		return result;

	}
}
