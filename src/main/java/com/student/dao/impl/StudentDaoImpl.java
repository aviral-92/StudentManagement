package com.student.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.student.dao.StudentDao;
import com.student.pojo.StudentDetail;

@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String addStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentDetail getStudent(StudentDetail studentDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateStudent(StudentDetail studentDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteStudent(StudentDetail studentDetail) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
