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
<a href = "index.jsp">Back</a><br/><br/>
<table border="1">
	<tr>
		<td>Id</td>
		<td>Name</td>
	</tr>
<c:forEach var="country" items="${countryController1.countries}">
	<tr>
		<td><c:out value="${country.id}"/></td>
		<td><c:out value="${country.name}"/></td>
	</tr>
</c:forEach>
</table>

</body>
</html>