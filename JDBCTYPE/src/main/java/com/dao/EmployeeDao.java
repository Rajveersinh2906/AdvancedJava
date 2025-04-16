package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Employee;
import com.util.EmployeeUtil;

public class EmployeeDao {

	public static void insertEmployee(Employee e)
	{
		try {
			Connection conn=EmployeeUtil.createConnection();
			String sql="insert into employee(name,email,job,jdes,location,dn) values(?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, e.getName());
			pst.setString(2, e.getEmail());
			pst.setString(3, e.getJob());
			pst.setString(4, e.getJdes());
			pst.setString(5, e.getLocation());
			pst.setString(6, e.getDn());
			pst.executeUpdate();
		} catch (Exception e2) {
                e2.printStackTrace();
		}
	}
	
	public static void updateEmployee(Employee e)
	{
		try {
			Connection conn=EmployeeUtil.createConnection();
			String sql="update employee set name=?,email=?,job=?,jdes=?,location=?,dn=? where e_id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, e.getName());
			pst.setString(2, e.getEmail());
			pst.setString(3, e.getJob());
			pst.setString(4, e.getJdes());
			pst.setString(5, e.getLocation());
			pst.setString(6, e.getDn());
			pst.setInt(7,e.getE_id());
			pst.executeUpdate();
		} catch (Exception e2) {
                e2.printStackTrace();
		}
	}
	
	public static List<Employee> getAllEmployee(){
		List<Employee> list=new ArrayList<Employee>();
		try {
			Connection conn=EmployeeUtil.createConnection();
			String sql="select * from employee";
			PreparedStatement pst=conn.prepareStatement(sql);
		    ResultSet rs=pst.executeQuery();
		    while(rs.next())
		    {
		    	Employee e=new Employee();
		    	e.setE_id(rs.getInt("e_id"));
		    	e.setName(rs.getString("name"));
		    	e.setEmail(rs.getString("email"));
		    	e.setJob(rs.getString("job"));
		    	e.setJdes(rs.getString("jdes"));
		    	e.setLocation(rs.getString("location"));
		    	e.setDn(rs.getString("dn"));
		    	list.add(e);
		    }
		} catch (Exception e) {
            e.printStackTrace();
		}
		return list;
	}
	
	public static void deleteEmployee(int e_id) {
		try {
		Connection conn=EmployeeUtil.createConnection();
		String sql="delete from employee where e_id=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setInt(1, e_id);
		pst.executeUpdate(); 
		} catch (Exception e) {
          e.printStackTrace();
		}
	}
	
	public static Employee getEmployeeById(int e_id)
	{
		Employee e=null;
		try {
	     Connection conn=EmployeeUtil.createConnection();
   	     String sql="select * from employee where e_id=?";
   	     PreparedStatement pst=conn.prepareStatement(sql);
   	     pst.setInt(1, e_id);
   	     ResultSet rs=pst.executeQuery();
   	     if(rs.next())
   	     {
   	    	 e=new Employee();
   	    	 e.setE_id(rs.getInt("e_id"));
   	    	 e.setName(rs.getString("name"));
   	    	e.setEmail(rs.getString("email"));
   	    	e.setJob(rs.getString("job"));
   	    	e.setJdes(rs.getString("jdes"));
   	    	e.setLocation(rs.getString("location"));
   	    	e.setDn(rs.getString("dn"));
   	    	
   	     }
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return e;
	}
}
