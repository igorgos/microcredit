<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.controller.LocationController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="locationController" class="com.controller.LocationController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buna ziua</title>
</head>
<body>
<table border="1"> 
	<tr>
		<td>Id localitate</td>
		<td>Localitate</td>
		<td>Țara</td>
		<td>Id țara</td>
	</tr>
	<c:forEach var="location" items="${locationController.locations}"> 
		<tr>
			<td><c:out value="${location.id}"/></td>
			<td><c:out value="${location.name}"/></td>
			<td><c:out value="${location.country.name}"/></td>
			<td><c:out value="${location.country.id}"/></td>
		</tr>
	</c:forEach>  
</table>  
</body>
</html>