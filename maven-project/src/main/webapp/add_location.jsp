<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="countryController" class="com.controller.CountryController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Location</title>
</head>
<body>
<a href = "locations.jsp">Back</a><br/><br/>
<form action="addLocation" method="post">
	<label for="location_name">Location name:</label>
	<input name="location_name" type="text"/><br/>
	
	<label for = "country">Country name:</label>
	<select name="country">
		<c:forEach var="country" items="${countryController.countries}">
			<option value="${country.id}"><c:out value="${country.name}"/></option>
		</c:forEach>
	</select>
	<br/>
	<input value="Save" type="submit"/>
	
	
</form>
	
</body>
</html>