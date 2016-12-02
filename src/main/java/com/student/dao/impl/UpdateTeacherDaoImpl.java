package com.student.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.student.pojo.TeacherDetails;

@Component
public class UpdateTeacherDaoImpl {

	public String updateTeacher(TeacherDetails teacherDetails) {

		String response = null;
		if (!StringUtils.isEmpty(teacherDetails)) {
			boolean teacherName = false, teacherAddress = false;
			List<Object> args = new ArrayList<Object>();
			StringBuilder query = new StringBuilder(
					"Update student_mgmt.teacher set ");

			if (!StringUtils.isEmpty(teacherDetails.getTeacher_name())) {
				query.append(" teacher_name = ? ");
				args.add(teacherDetails.getTeacher_name());
				teacherName = true;
			}

			if (!StringUtils.isEmpty(teacherDetails.getTeacher_address())) {
				if (teacherName) {
					query.append(", teacher_address=? ");
					args.add(teacherDetails.getTeacher_address());
					teacherAddress = true;
				} else {
					query.append(" teacher_address=?");
					args.add(teacherDetails.getTeacher_address());
					teacherAddress = true;
				}
			}
			if (teacherAddress || teacherName) {
				if (teacherDetails.getTeacher_id() > 0) {
					query.append(" WHERE teacher_id = ? ");
					args.add(teacherDetails.getTeacher_id());
				} else {
					response = "Please provide Teacher Id to update";
				}
			} else {
				response = " Please provide data to update either Name or Address";
			}

			response = "Data successfully Updated.......!!!!!!!";
		} else {
			response = "Please provide data to update...!!!";
		}

		return response;
	}

}
