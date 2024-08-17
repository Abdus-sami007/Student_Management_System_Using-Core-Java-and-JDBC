package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Student;

public class Student_Controller {

	public int saveStudent(Student student) {
		int n=0;
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcsmsproject", "postgres", "root");
			
			PreparedStatement psmt =  con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			
			psmt.setInt(1,student.getId());
			psmt.setString(2,student.getName());
			psmt.setString(3,student.getEmail());
			psmt.setString(4,student.getPassword());
			psmt.setLong(5,student.getMob());
			psmt.setString(6,student.getGender());
			psmt.setString(7,student.getDob());
			
			 n = psmt.executeUpdate();
			 con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}
	
	public ResultSet findStudentById(int id) {
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
			
Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcsmsproject", "postgres", "root");
			
			PreparedStatement psmt =  con.prepareStatement("select * from student where id = ?"); 
			
			psmt.setInt(1, id);
			
		    rs = psmt.executeQuery();
		    
		    con.close();
			    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int updateStudentById(int id, String newEmail) {
		int n=0;
		try {
			Class.forName("org.postgresql.Driver");
			
Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcsmsproject", "postgres", "root");
			
			PreparedStatement psmt =  con.prepareStatement("update student set email=? where id=?");
			
			psmt.setString(1, newEmail);
			psmt.setInt(2,id);
			
			      n = psmt.executeUpdate();
			
			      con.close();
			   
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	public int deleteStudentById(int id) {
		int n=0;
		try {
			Class.forName("org.postgresql.Driver");
			
Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcsmsproject", "postgres", "root");
			
			PreparedStatement psmt =  con.prepareStatement("delete from student where id=?");
			
			psmt.setInt(1,id);
			
			      n = psmt.executeUpdate();
			
			      con.close();
			   
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
  public ResultSet findAll() {
	  
	  ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
			
Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcsmsproject", "postgres", "root");
			
			PreparedStatement psmt =  con.prepareStatement("select * from student"); 
			
		    rs = psmt.executeQuery();
		    
		    con.close();
			    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

  }

