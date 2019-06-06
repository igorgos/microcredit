<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.controller.RoleController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="roleController" class = "com.controller.RoleController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roles</title>
</head>
<body>
<a href = "index.jsp">Back</a><br/><br/>
<table border = "1">
	<tr>
		<td>Numele Utilizatorului</td>
		<td>Id Profesie</td>
		<td>Profesie</td>
	</tr>
<c:forEach var = "role" items = "${roleController.roles}">
	<tr>
<%-- 		<td><c:forEach var="user" items="${role.users}"> --%>
<%--  				<c:out value="${user.name}"/> --%>
<%-- 			</c:forEach></td>  --%>
		<td><c:out value = "${role.users.name}"/></td>
		<td><c:out value = "${role.id}"/></td>
		<td><c:out value = "${role.name}"/></td>
	</tr>
</c:forEach>
</table>
</body>
</html>