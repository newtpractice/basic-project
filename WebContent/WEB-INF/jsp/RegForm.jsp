<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#Table-box {
	width: 400px;
	padding: 30px;
	margin: 100px auto;
	border: 2px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
	border: 2px solid #31708f;
}
</style>
</head>
<body>
<body bgcolor="#AAE6FA">
	<center>
	<form method="GET" action="newcustomer">
		<div id="Table-box">
			<h1>New Registration</h1>
			<table>


				<tr>
					<td>Customer Id:</td>
					<td><input type="text" name="customerid" />
				</tr>

				<tr>
					<td>Full Name:</td>
					<td><input type="text" name="customername" />
				</tr>

                 <tr>
					<td>Login Id:</td>
					<td><input type="text" name="loginid" />
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" />
				</tr>
				<tr>
					<td>Contact No:</td>
					<td><input type="text" name="phonenumber" />
				</tr>
				


			</table>
			<br>
			
				<button type="submit">Save</button>
			</form>
		</div>
	</center>
</body>
</html>