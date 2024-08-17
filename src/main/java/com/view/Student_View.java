package com.view;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.controller.Student_Controller;
import com.model.Student;

public class Student_View {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static Student getStudentObject() {
		Student s = new Student();
		
		System.out.println("Enter the id:");
		 int id =sc.nextInt();
		 
		System.out.println("Enter the name:");
		sc.nextLine();
		 String name = sc.nextLine();
		 
		System.out.println("Enter the mob Number:");
		 long mob  =sc.nextLong();
		 
		System.out.println("Enter Gender:");
		sc.nextLine();
		 String gender = sc.nextLine();
		 
		System.out.println("Enter Email:");
		String email = sc.nextLine();
		
		System.out.println("Enter Date Of Birth:");
		String dob = sc.nextLine();
		
		System.out.println("Enter password:");
		 String password = sc.nextLine();
		 
		 s.setId(id);
		 s.setName(name);
		 s.setMob(mob);
		 s.setGender(gender);
		 s.setEmail(email);
		 s.setDob(dob);
		 s.setPassword(password);
		 
		 return s;
		 }
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to student Portal...");
		 Student_Controller controller = new Student_Controller();
		 
		while(true) {
			System.out.println("1.Save Student");
			System.out.println("2.Find Student by Id");
			System.out.println("3.Update Student by Id");
			System.out.println("4.Delete Student by Id");
			System.out.println("5.Find All");
			System.out.println("6.Exit");
			
			System.out.println("Enter your choice:");
			int choice= sc.nextInt();
			
			switch(choice) {
			  case 1:
				  Student student = getStudentObject();
				  int n1n  = controller.saveStudent(student);
				  if(n1n!=0)
					  System.out.println("Data saved...");
				  else
					  System.out.println("Data not saved...");
				  break;
				  
			  case 2:
				  System.out.println("Enter the student id");
				  int id = sc.nextInt();
				  ResultSet rs = controller.findStudentById(id);
				  if(rs!=null) {
					  try {
					  if(rs.next()) {
						  System.out.println("-------------------Student Detail-------------------");
						  System.out.println(rs.getInt(1));
						  System.out.println(rs.getString(2));
						  System.out.println(rs.getString(3));
						  System.out.println(rs.getString(4));
						  System.out.println(rs.getLong(5));
						  System.out.println(rs.getString(6));
						  System.out.println(rs.getString(7));
						  System.out.println("--------------------------------------------------------");
					  }
				  
				  else {
					  System.out.println("record not found");
				  }
					  }  catch(SQLException e) {
					  e.printStackTrace();
				  }
				  }
					  
				  break;
				  
			  case 3:
				  System.out.println("Enter student Id");
				  int id1=sc.nextInt();;
				 System.out.println("Enter the new email");
				 sc.nextLine();
				  String newEmail = sc.nextLine();
				  
				  int n1   = controller.updateStudentById(id1,newEmail);
				  
				  if(n1!=0)
					  System.out.println("Data Updated...");
				  else
					  System.out.println("Data not Updated...");
				         
				  break;
				  
			  case 4:
				  System.out.println("Enter student Id");
				  int id2=sc.nextInt();
				  
				  int n3 = controller.deleteStudentById(id2);
				  
				  if(n3!=0)
					  System.out.println("Data deleted...");
				  else
					  System.out.println("Data not deleted...");
				         
				  break;
				  
			  case 5:
				 ResultSet rs1 = controller.findAll();
				 
				 if(rs1 !=null) {
					  try {
					  while(rs1.next()) {
						  System.out.println("-------------------Student Detail-------------------");
						  System.out.println(rs1.getInt(1));
						  System.out.println(rs1.getString(2));
						  System.out.println(rs1.getString(3));
						  System.out.println(rs1.getString(4));
						  System.out.println(rs1.getLong(5));
						  System.out.println(rs1.getString(6));
						  System.out.println(rs1.getString(7));
						  System.out.println("--------------------------------------------------------");
					  }
					  }  catch(SQLException e) {
					  e.printStackTrace();
				  }
				  }
				  break;	  
			  
			  case 6:
				  System.out.println("Thank You...");
				  return;	
			
			   default:
				   System.out.println("Invalid Choice...");
				   break;
		  
			}
		}
		
	}

}
