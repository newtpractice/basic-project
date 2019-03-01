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
	width: 700px;
	padding: 20px;
	margin: 100px auto;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
	border: 2px solid #31708f;
}
.msg1{
	color:red
}
</style>
</head>
<body bgcolor="#AAE6FA">
<center>
<div id="Table-box">

<caption><h1  style="text-align:center;">Category List</h1></caption>

    <table border='2' width='700' cellpadding='2' cellspacing='2'>
        <thead>
            <tr>
		    
		    <th>CategoryName</th>
		    <th>View</th>
		    
	         </tr>
        </thead>
        <tbody>
            <c:forEach items="${categories}" var="category">
                <tr>
                    
                    <td><c:out value="${category.categoryname}" /></td>
                    <td><a href="orderproducts?id=<c:out value="${category.categoryid}"/>"> View </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
</center>
</body>
</html>