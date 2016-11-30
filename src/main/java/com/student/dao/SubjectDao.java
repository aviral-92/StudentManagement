package com.student.dao;

import com.student.pojo.SubjectDetails;
import java.util.List;

public interface SubjectDao {
	

	public String addSubject(SubjectDetails subjectDetails);

	public List<SubjectDetails> getSubject(SubjectDetails subjectDetails);

	/*public String updateSubject(SubjectDetails subjectDetails);

	public String deleteSubject(SubjectDetails subjectDetails);
}*/
}
