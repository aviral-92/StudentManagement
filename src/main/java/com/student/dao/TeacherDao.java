package com.student.dao;

import java.util.List;

import com.student.pojo.TeacherDetails;

public interface TeacherDao {

	public String addTeacher(TeacherDetails teacherDetails);

	public List<TeacherDetails> getTeacher(TeacherDetails teacherDetails);

	public String updateteacher(TeacherDetails teacherDetails);

	public String deleteTeacher(TeacherDetails teacherDetails);
	
}
