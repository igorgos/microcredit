<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.controller.RoleController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="roleController" class="com.controller.RoleController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Roles</title>
</head>
<body>
<table border="1"> 
	<tr>
		<td>Id role</td>
		<td>Denumirea</td>
	</tr>
	<c:forEach var="role" items="${roleController.roles}"> 
		<tr>
			<td><c:out value="${role.id}"/></td>
			<td><c:out value="${role.name}"/></td>
		</tr>
	</c:forEach>  
</table>  
</body>
</html>