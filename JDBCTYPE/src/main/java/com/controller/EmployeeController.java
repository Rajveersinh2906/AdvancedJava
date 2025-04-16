package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bean.Employee;
import com.dao.EmployeeDao;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert"))
		{
		Employee e=new Employee();
	 	e.setName(request.getParameter("name"));
		e.setEmail(request.getParameter("email"));
		e.setJob(request.getParameter("job"));
		e.setJdes(request.getParameter("jdes"));
		e.setLocation(request.getParameter("location"));
		e.setDn(request.getParameter("dn"));
	    EmployeeDao.insertEmployee(e);
	    System.out.println("Data Insert Successfully");
	    response.sendRedirect("show.jsp");
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			int e_id=Integer.parseInt(request.getParameter("e_id"));
			EmployeeDao.deleteEmployee(e_id);
			response.sendRedirect("show.jsp");
		}
		else if(action.equalsIgnoreCase("edit"))
		{
			int e_id=Integer.parseInt(request.getParameter("e_id"));
			Employee e=EmployeeDao.getEmployeeById(e_id);
			request.setAttribute("e", e);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("update"))
		{
			Employee e=new Employee();
			e.setE_id(Integer.parseInt(request.getParameter("e_id")));
		 	e.setName(request.getParameter("name"));
			e.setEmail(request.getParameter("email"));
			e.setJob(request.getParameter("job"));
			e.setJdes(request.getParameter("jdes"));
			e.setLocation(request.getParameter("location"));
			e.setDn(request.getParameter("dn"));
		    EmployeeDao.updateEmployee(e);
		    System.out.println("Data update  Successfully");
		    response.sendRedirect("show.jsp");
		}
	}

}
