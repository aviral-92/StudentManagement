package com.mahima;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.student.pojo.TeacherDetails;

public class mahima {

	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private java.sql.Connection connection = null;
	private Scanner sc = null;

	public java.sql.Connection getConnection() {
		String dbname = "student_mgmt", url = "jdbc:mysql://10.2.0.207:3306/", username = "root", password = "root";
		try {
			connection = DriverManager.getConnection(url + dbname, username,
					password);
		} catch (SQLException sql) {
			sql.printStackTrace();
		}
		return connection;
	}

	public void insertData(){
		String query="insert into student_mgmt.teacher(teacher_id,teacher_name,teacher_address) values(?,?,?)";
		sc= new Scanner(System.in);
		TeacherDetails teacherDetails= new TeacherDetails();
		System.out.println("Enter teacher details");
		System.out.println("Teacher id");
		teacherDetails.setTeacher_id(sc.nextInt());
		System.out.println("Teacher name");
		teacherDetails.setTeacher_name(sc.next());
		System.out.println("Teacher address");
		teacherDetails.setTeacher_address(sc.next());
		
		try{
			if(connection== null)
				connection=getConnection();
			ps= connection.prepareStatement(query);
			ps.setInt(1, teacherDetails.getTeacher_id());
			ps.setString(2, teacherDetails.getTeacher_name());
			ps.setString(3, teacherDetails.getTeacher_address());
			ps.execute();
			System.out.println("Insert data");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try{
				connection.close();
				ps.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		mahima mahima = new mahima();
		mahima.insertData();
	}
}
