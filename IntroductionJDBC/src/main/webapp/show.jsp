<%@page import="com.dao.EmployeeDao"%>
<%@page import="com.bean.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<table border="1" cellpaddding="10px" cellspacing="10px" width="100%">
  <tr>
  <th>E_ID</th>
  <th>NAME</th>
  <th>EMAIL</th>
  <th>JOB</th>
  <th>JOB DESCRIPTION</th>
  <th>LOCATION</th>
  <th>DEPARTMENT NUMBER</th>
  <th>EDIT</th>
  <th>DELETE</th>
  </tr>
  <%
  List<Employee> list=EmployeeDao.getAllEmployee();
  for(Employee e:list)
  {
  %>
  <tr>
   <td><%=e.getE_id()%></td> 
    <td><%=e.getName() %></td>
     <td><%=e.getEmail() %></td>
      <td><%=e.getJob()%></td>
       <td><%=e.getJdes() %></td>
        <td><%=e.getLocation() %></td>
         <td><%=e.getDn() %></td>
         <td>
         <form name="edit" method="post" action="EmployeeController">
         <input type="hidden" name="e_id" value="<%=e.getE_id() %>">
         <Input type="submit" name="action" value="EDIT" class="btn btn-primary">
          </form>
         </td>
          <td>
         <form name="delete" method="post" action="EmployeeController">
         <input type="hidden" name="e_id" value="<%=e.getE_id() %>">
         <Input type="submit" name="action" value="DELETE" class="btn btn-danger">
          </form>
         </td>
  <tr>
  <%
  }
  %>
</table>
<a href="index.jsp">Add To Employee Detail</a>
</body>
</html>