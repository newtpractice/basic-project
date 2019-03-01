<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>

table, th, td {
    border: 1px solid black;
    padding: 5px;
}
table {
    border-spacing: 2px;
    background-color:powderblue;
    style="width:70%";
}
</style>
</head>
<body>
<caption><h1  style="text-align:center;">Admin Login Page</h1></caption>
<form action="authenticate" >
<table align="center">
  <tr>
   
    <td>UserName:<input type="text" name="username" value="admin"></td>
    
    <td>Password:<input type="password" name="password" value="newt@123"></td>
    <td>
    <p align="center">
    <button type="submit">Submit</button>
	</p>
	</td>
  </tr>
 </table>
</form>
</body>
</html>
