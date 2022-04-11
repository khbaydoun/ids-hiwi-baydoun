<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee information</title>
</head>
<body>
<div align="center">
    <h1>Employee Information</h1>

    <table border ="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Country</th>
            <th>Location</th>
            <th>Gender</th>
            
        </tr>
        <c:forEach items="${employeeList}" var ="employees">
            <tr>
                <td>${employees.id}</td>
                <td>${employees.name}</td>
                <td>${employees.email}</td>
                <td>${employees.password}</td>
				<td>${employees.country}</td>
				<td>${employees.location}</td>
				<td>${employees.gender}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5"><a href="cancel" class="badge badge-dark">Go Back</a></td>
        </tr>
    </table>
</div>
</body>
</html>