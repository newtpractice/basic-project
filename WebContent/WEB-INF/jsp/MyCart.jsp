<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<style>
.right {
	background: #d9edf7;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	-ms-text-overflow: ellipsis;
	float: right;
}

#Table-box {
	width: 600px;
	padding: 20px;
	margin: 100px auto;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
	border: 1px solid #31708f;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#myDiv {
	background-color: #d9edf7;
	border-color: #bce8f1;
	width: 200px;
}
</style>
</head>
<body bgcolor="#AAE6FA">
	<center>
		<div id="Table-box">
			<h1>My Cart</h1>
			<h2>Items Saved in Cart</h2>
			<table border='1.5' width='600' cellpadding='1' cellspacing='1'>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Place Order</th>
				</tr>
				<tbody>

					<c:forEach items="${products}" var="product">
						<tr>
							<td><c:out value="${product.productid}" /></td>
							<td><c:out value="${product.productname}" /></td>
							<td><c:out value="${product.productprice}" /></td>
							<td><a href="orderconfirmation?id=<c:out value="${product.productid}"/>">Place Order</a>
						</tr>
					</c:forEach>

				</tbody>

			</table>

			<p>
				<a href="allproducts">Add more products to Cart</a>
			</p>
	</center>

	</div>



</body>
</html>