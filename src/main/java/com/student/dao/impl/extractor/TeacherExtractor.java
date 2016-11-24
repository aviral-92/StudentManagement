package com.student.dao.impl.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.student.pojo.TeacherDetails;

public class TeacherExtractor implements ResultSetExtractor<List<TeacherDetails>>{

	public List<TeacherDetails> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<TeacherDetails> teacherDetails = new ArrayList<TeacherDetails>();
		TeacherDetails details = null;
		while(rs.next()){
			details= new TeacherDetails();
			details.setTeacher_id(rs.getInt("teacher_id"));
			details.setTeacher_name(rs.getString("teacher_name"));
			details.setTeacher_address(rs.getString("teacher_address"));
			teacherDetails.add(details);
		}
		
		return teacherDetails;
	}

	

}
