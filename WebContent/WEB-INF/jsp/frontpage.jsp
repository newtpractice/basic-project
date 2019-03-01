<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p style="text-align:center;"><a href="add.jsp">Add New Book</a></p>
<caption><h1  style="text-align:center;">Employee List</h1></caption>

    <table border=1>
        <thead>
            <tr>
                <th>Id</th>
                <th>name</th>
                <th>password</th>
                <th>email</th>
                <th>country</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="book">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.name}" /></td>
                    <td><c:out value="${book.password}" /></td>
                    <td><c:out value="${book.email}" /></td>
                    <td><c:out value="${book.country}" /></td>
                    <td><a href="select?id=<c:out value="${book.id}"/>">Update</a></td>
                    <td><a href="delete?id=<c:out value="${book.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>