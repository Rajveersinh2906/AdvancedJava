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
<center>
<h1>Employee Information </h1>
</center>
<hr>
<form name="frm" method="post" action="EmployeeController">
 <table>
    <tr>
    <td>Name</td>
    <td><input type="text" name="name"></td>
    </tr>
    <tr>
    <td>Email</td>
    <td><input type="text" name="email"></td>
    </tr>
    <tr>
    <td>Job</td>
    <td><input type="text" name="job"></td>
    </tr>
    <tr>
    <td>Job Description</td>
    <td><textarea rows="5" cols="23" name="jdes"></textarea></td>
    </tr>
    <tr>
    <td>Location</td>
    <td><input type="text" name="location"></td>
    </tr>
    <tr>
    <td>Department Number</td>
    <td><input type="text" name="dn"></td>
    </tr>
    <tr>
    <td colspan="2" align="center">
    <input type="submit" name="action" value="INSERT">
    </td>
    </tr>
 </table>
 <a href="show.jsp">Show All Employee Data</a>
</form>
</body>
</html> 