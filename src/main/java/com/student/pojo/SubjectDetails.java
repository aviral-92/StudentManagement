package com.student.pojo;

public class SubjectDetails {
	int sub_code;
	String sub_name;
	String sub_marks;

	public SubjectDetails() {
		
	}

	public SubjectDetails(int code, String name, String marks) {
		super();
		this.sub_code = code;
		this.sub_name = name;
		this.sub_marks = marks;
	}

	public int getSub_code() {
		return sub_code;
	}

	public void setSub_code(int sub_code) {
		this.sub_code = sub_code;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public String getSub_marks() {
		return sub_marks;
	}

	public void setSub_marks(String sub_marks) {
		this.sub_marks = sub_marks;
	}
}
