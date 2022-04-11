<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Employees List</title>
    </head>
    <body>
        <div align="center" class="table-responsive">
            <h1>Employees List</h1>
            <form method="get" action="search" class="px-2 py-3">
                <!--
-->

                <div class="input-group col-md-4">
                    <div class="input-group-append"></div>
                </div>
            </form>

            <table border="1" cellpadding="5" class="table w-auto table-striped">
                <tr>
                    <th>ID</th>
           		    <th>Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Country</th>
                    <th>Location</th>
                    <th>Gender</th>
                </tr>
                <t:forEach items="${employeeList}" var="employee">
                    <tr>
                        <td>${employees.id}</td>
                		<td>${employees.name}</td>
               			<td>${employees.email}</td>
                		<td>${employees.password}</td>
						<td>${employees.country}</td>
						<td>${employees.location}</td>
						<td>${employees.gender}</td>
                    </tr>
                </t:forEach>
            </table>
        </div>
    </body>
</html>
