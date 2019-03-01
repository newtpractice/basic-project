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

.container {
    width: 1000px;
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
	border: 2px solid #31708f;
}
.left {
    max-width: 100%;
    background:#d9edf7;
    white-space:nowrap;
    overflow:hidden;
    text-overflow:ellipsis;
    -ms-text-overflow:ellipsis;
    float: left;
}

</style>
</head>
<body bgcolor="white">


<div id="Table-box">
<table border='2' width='600' cellpadding='2' cellspacing='2'>
        <thead>
           <tr>
	       <th>ProductId</th>
		   <th>ProductName</th>
		   <th>ProductPrice</th>
		   <th>Add To Cart </th>
	       </tr>
	</thead>
        <tbody>
            <c:forEach items="${products}" var="book">
                <tr>
                    <td><c:out value="${book.productid}" /></td>
                    <td><c:out value="${book.productname}" /></td>
                    <td><c:out value="${book.productprice}" /></td>
                    <td><a href="addtocart?id=<c:out value="${book.productid}"/>"> Add To Cart</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>


<div class="container">
<div class = "left">
<table border='2' width='200' cellpadding='2' cellspacing='2'>
	<tr>
		<th>CategoryName</th>
	</tr>
	<tbody>
	<c:forEach items="${categoryname}" var="category">	
			<tr>
				<td><c:out value="${category}" /></td>
			</tr>			
	</c:forEach>			
	</tbody>
</table>
</div>
</div>	
<center><p><a href="backtohomepage">Back To Home Page</a></p></center>

</body>		
</html>