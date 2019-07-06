<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.controller.LocationController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id = "locationController" class = "com.controller.LocationController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locations</title>
</head>
<body>
<a href = "add_location.jsp">Add Location</a><br/><br/>
<table border = "1">
	<tr>
		<td>Id Localitate</td>
		<td>Localitate</td>
		<td>Id Tara</td>
		<td>Tara</td>
		<td>Delete button</td>
	</tr>
<c:forEach var = "location" items = "${locationController.locations}">
	<tr>
		<td><c:out value = "${location.id}"/></td>
		<td><c:out value = "${location.name}"/></td>
		<td><c:out value = "${location.country.id}"/></td>
		<td><c:out value = "${location.country.name}"/></td>
		<td><a href="addLocation?location_id=${location.id}">Delete</a></td>
	</tr>
</c:forEach>
</table><br/>
<a href = "index.jsp">Back</a><br/><br/>
</body>
</html>