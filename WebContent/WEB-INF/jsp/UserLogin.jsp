<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7; 
	/* background-image:url(images/lcd47ml.jpg); */
	border-color: #bce8f1;
	border: 1px solid #31708f;
}
 /* body{
 /* background="C:\Users\Shubhra Suresh Kumar\Downloads\lcd47ml.jpg" background-size=100%> */
  background-image: url("images/lcd47ml.jpg");
} */

</style>
</head>
<body background="./lcd47ml.jpg">
	<center>
	<div id="login-box">
	<h1>Customer Login</h1>
	
	<form action="authenticatecustomer" method="post">
	<br>Login Id:<input type="text" id="loginid" name="loginid">
	<br>
	<br>Password:<input type="password" id="password" name="password">
	<br><br>Click<a href="startadmin">&nbsphere</a>&nbspfor Admin Login
	<br><br>Click<a href="register">&nbsphere</a>&nbspfor New User Registration
	<br><br><input type = "submit" value = "Submit">
	</form>
	</div>
	</center>

</body>
</html>