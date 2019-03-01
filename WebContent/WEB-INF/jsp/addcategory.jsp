<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<body bgcolor="#AAE6FA">
<center>
<h1>Create New Category</h1>
<div id="Table-box">
<form method="get" action="newrecord">
	<table>
		<tr>
			<td>Category Name:</td>
			<td><input type="text" name="categoryname" />
		</tr>
		
		<tr>
			<td>Category Id:</td>
			<td><input type="text" name="categoryid" />
		</tr>

	</table>
	
    <button type="submit">Save</button>
</form>
</div>
</center>
</body>
</html>