package com.student.pojo;

public class StudentDetail {
	int Student_rollno;
	String student_name;
	String student_address;
	String student_class;

	public StudentDetail() {
		super();
	}

	public StudentDetail(int student_rollno, String student_name,
			String student_address, String student_class) {
		super();
		Student_rollno = student_rollno;
		this.student_name = student_name;
		this.student_address = student_address;
		this.student_class = student_class;
	}

	public int getStudent_rollno() {
		return Student_rollno;
	}

	public void setStudent_rollno(int student_rollno) {
		Student_rollno = student_rollno;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public String getStudent_class() {
		return student_class;
	}

	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}

}
