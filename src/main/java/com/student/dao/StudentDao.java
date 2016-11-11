package com.student.dao;

import com.student.pojo.StudentDetail;

public interface StudentDao {

	public String addStudent();

	public StudentDetail getStudent(StudentDetail studentDetail);

	public String updateStudent(StudentDetail studentDetail);

	public String deleteStudent(StudentDetail studentDetail);
}
