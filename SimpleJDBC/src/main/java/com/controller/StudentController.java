package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.Student;
import com.dao.StudentDao;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("insert"))
		{
		  Student s=new Student();
		s.setFname(request.getParameter("fname"));
		s.setLname(request.getParameter("lname"));
		s.setEmail(request.getParameter("email"));
		s.setMobile(request.getParameter("mobile"));
		s.setAddress(request.getParameter("address"));
		s.setGender(request.getParameter("gender"));
		StudentDao.insertStudent(s);
		System.out.println("Data Inserted Successfully");
		response.sendRedirect("show.jsp");
		}
	

	}

}
