<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.controller.UserController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="userController" class="com.controller.UserController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>
<table border="1"> 
	<tr>
		<td>Id user</td>
		<td>Numele</td>
		<td>Adresa</td>
		<td>Data nasterii</td>
		<td>Denumirea role</td>
		<td>Denumirea hobby</td>
	</tr>
	<c:forEach var="user" items="${userController.users}"> 
		<tr>
			<td><c:out value="${user.id}"/></td>
			<td><c:out value="${user.name}"/></td>
			<td><c:out value="${user.adress}"/></td>
			<td><c:out value="${user.birthDate}"/></td>
			<td><c:out value="${user.role.name}"/></td>
			<td><c:out value="${user.hobby.name}"/></td>
		</tr>
	</c:forEach>  
</table>  
</body>
</html>