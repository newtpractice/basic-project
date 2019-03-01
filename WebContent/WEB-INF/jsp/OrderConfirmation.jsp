<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#Table-box {
	width: 600px;
	padding: 30px;
	margin: 100px auto;
	border: 2px solid transparent;
	border-radius: 4px;
	color: #FFA07A;
	background-color:#31708f ;
	border-color: #bce8f1;
	border: 1px solid #31708f;
	font-size: 20px;
}
</style>
</head>
<body>
<body bgcolor="WHITE">
	<center>
		<div id="Table-box">
			<h1>Order Confirmation</h1>
<form method="GET" action="ordersuccessfullyplaced">
			
			<table>


				<tr>
					<td>Product Id:</td>
					<td><input type="text" name="productid" value="${products.productid}" />
				</tr>

				<tr>
					<td>Product Name:</td>
					<td><input type="text" name="productname" value="${products.productname}" />
				</tr>

				<tr>
					<td>Product Price:</td>
					<td><input type="text" name="productprice" value="${products.productprice}"/>
				</tr>
				<tr>
					<td>Quantity:</td>
					<td><input type="text" name="quantity" value="${products.quantity}"/>
				</tr>


			</table>
			<br>
			
				<button type="submit">Place Order</button>
			</form>
		</div>
	</center>
</body>
</html>