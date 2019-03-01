<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#Table-box {
	width: 600px;
	padding: 20px;
	margin: 100px auto;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
	border: 2px solid #31708f;
}
 </style>
</head>
<body>
<div id="Table-box">

<h1><center>Welcome!</center></h1>
</div>
<center>

<p><a href="editprofile?id=<c:out value="${customerid}"/>"> Edit Profile</a></p>
<p><a href="logout">LogOut</a></p>
<p><a href="ordercategories">Order</a></p>
<p><a href="mycart">ViewCart</a></p>
</center>

</body>
</html>