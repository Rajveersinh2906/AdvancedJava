<%@page import="com.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
tr,td{
 padding:10px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<% 
   Employee e=(Employee)request.getAttribute("e"); 
 %>
<center>
<h1>Employee Information </h1>
</center>
<hr>
<form name="frm" method="post" action="EmployeeController">
 <table>
    <tr>
    <td> <input type="hidden" name="e_id" value="<%=e.getE_id() %>"></td>
    </tr>
    <tr>
    <td>Name</td>
    <td><input type="text" name="name" value="<%=e.getName() %>"></td>
    </tr>
    <tr>
    <td>Email</td>
    <td><input type="text" name="email" value="<%=e.getEmail() %>"></td>
    </tr>
    <tr>
    <td>Job</td>
    <td><input type="text" name="job" value="<%=e.getJob() %>"></td>
    </tr>
    <tr>
    <td>Job Description</td>
    <td><textarea rows="5" cols="23" name="jdes" ><%=e.getJdes() %></textarea></td>
    </tr>
    <tr>
    <td>Location</td>
    <td><input type="text" name="location" value="<%=e.getLocation() %>"></td>
    </tr>
    <tr>
    <td>Department Number</td>
    <td><input type="text" name="dn" value="<%=e.getDn() %>"> </td>
    </tr>
    <tr>
    <td colspan="2" align="center">
    <input type="submit" name="action" value="UPDATE">
    </td>
    </tr>
 </table>
</form>
</body>
</html> 