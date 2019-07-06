<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.controller.CountryController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:useBean id="countryController1" class="com.controller.CountryController"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Countries</title>
</head>
<body>
<a href = "add_country.jsp">Add country</a><br/><br/>
<table border="1">
	<tr>
		<td>Id</td>
		<td>Name</td>
		<td>Phone</td>
		<td>Delete</td>
	</tr>
	
<c:forEach var="country" items="${countryController1.countries}">

	<tr>
		<td><c:out value="${country.id}"/></td>
		<td><a href="edit_country.jsp?country_id=${country.id}"><c:out value="${country.name}"/></a></td>
		<td><c:out value="${country.phone}"/></td>
		<td><a href="addCountry?country_id=${country.id}">Delete</a></td>
	</tr>
</c:forEach>
</table><br/>
<a href = "index.jsp">Back</a><br/><br/>

<audio controls="controls">
		<source src="copilaria.mp3" type="audio/mp3"/>
</audio>
</body>
</html>