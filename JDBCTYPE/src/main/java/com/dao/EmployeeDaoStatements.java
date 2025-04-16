package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Employee;
import com.util.EmployeeUtil;

public class EmployeeDaoStatements {

    public static void insertEmployee(Employee e) {
        try {
            Connection conn = EmployeeUtil.createConnection();
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO employee(name, email, job, jdes, location, dn) VALUES ('" +
                    e.getName() + "', '" + e.getEmail() + "', '" + e.getJob() + "', '" +
                    e.getJdes() + "', '" + e.getLocation() + "', '" + e.getDn() + "')";

            stmt.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void updateEmployee(Employee e) {
        try {
            Connection conn = EmployeeUtil.createConnection();
            Statement stmt = conn.createStatement();

            String sql = "UPDATE employee SET name='" + e.getName() +
                    "', email='" + e.getEmail() +
                    "', job='" + e.getJob() +
                    "', jdes='" + e.getJdes() +
                    "', location='" + e.getLocation() +
                    "', dn='" + e.getDn() +
                    "' WHERE e_id=" + e.getE_id();

            stmt.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try {
            Connection conn = EmployeeUtil.createConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee e = new Employee();
                e.setE_id(rs.getInt("e_id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setJob(rs.getString("job"));
                e.setJdes(rs.getString("jdes"));
                e.setLocation(rs.getString("location"));
                e.setDn(rs.getString("dn"));
                list.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static void deleteEmployee(int e_id) {
        try {
            Connection conn = EmployeeUtil.createConnection();
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM employee WHERE e_id=" + e_id;
            stmt.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Employee getEmployeeById(int e_id) {
        Employee e = null;
        try {
            Connection conn = EmployeeUtil.createConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE e_id=" + e_id;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                e = new Employee();
                e.setE_id(rs.getInt("e_id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setJob(rs.getString("job"));
                e.setJdes(rs.getString("jdes"));
                e.setLocation(rs.getString("location"));
                e.setDn(rs.getString("dn"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }
}
