package com.student.dao.impl.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.student.pojo.SubjectDetails;

public class SubjectExtractor implements
		ResultSetExtractor<List<SubjectDetails>> {

	public List<SubjectDetails> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<SubjectDetails> subjectDetails = new ArrayList<SubjectDetails>();
		SubjectDetails subjectDetail = null;
		while (rs.next()) {
			subjectDetail = new SubjectDetails();
			subjectDetail.setSub_code(rs.getInt("sub_code"));
			subjectDetail.setSub_name(rs.getString("sub_name"));
			subjectDetail.setSub_marks(rs.getString("sub_marks"));
			subjectDetails.add(subjectDetail);
		}

		return subjectDetails;
	}

}
