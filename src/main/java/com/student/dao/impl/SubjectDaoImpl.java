package com.student.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.student.dao.SubjectDao;
import com.student.dao.impl.extractor.SubjectExtractor;
import com.student.pojo.SubjectDetails;

@Component
public class SubjectDaoImpl implements SubjectDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String addSubject(SubjectDetails subjectDetails) {
		String query = "INSERT INTO STUDENT_MGMT.SUBJECT (sub_code, sub_name, sub_marks) values(?,?,?)";
		String response = null;
		Object args[] = { subjectDetails.getSub_code(),
				subjectDetails.getSub_name(), subjectDetails.getSub_marks() };
		int num = jdbcTemplate.update(query, args);

		if (num > 0) {
			response = "Successfully inserted data of subject and subject code is"
					+ subjectDetails.getSub_code();
		} else {
			response = "No data inserted";
		}

		return response;
	}

	public List<SubjectDetails> getSubject(SubjectDetails subjectDetails) {
		String query = "SELECT * from STUDENT_MGMT.SUBJECT where sub_code = ? ";

		// String response = null;
		Object args[] = { subjectDetails.getSub_code()};
		List<SubjectDetails> response = jdbcTemplate.query(query, new SubjectExtractor(), args);

		return response;
	}
	/*
	 * public String updateSubject(SubjectDetails subjectDetails) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * public String deleteSubject(SubjectDetails subjectDetails) { // TODO
	 * Auto-generated method stub return null; }
	 */

}
