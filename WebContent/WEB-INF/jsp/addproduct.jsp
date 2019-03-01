<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
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
<h1>Add New Product</h1>
<div id="Table-box">

<form:form   method="get" action="newproduct" enctype="multipart/form-data" >
	<table>
		<tr>
			<td><form:label path="productname">Product Name:</form:label></td>
			<td><form:input path="productname"/></td>
		</tr>
		
		<tr>
			<td><form:label path="productprice"> Product Price:</form:label></td>
			<td><form:input path="productprice"/></td>
		</tr>
		
		<tr>
			<td><form:label path="categoryid"> Category Id:</form:label></td>
			<td><input type="text" name="categoryid" value="${id}"/></td>
		</tr>
		<tr>
			<td><form:label path="productimage"> Product Image:</form:label></td>
			<td><input type="file" name="file" id="file"></input></td>
		</tr>

	</table>
	
    <button type="submit">Save</button>
</form:form>
</div>
</center>
</body>
</html>