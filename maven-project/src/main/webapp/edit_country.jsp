<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Country"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:useBean id="countryController" class="com.controller.CountryController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit country</title>
</head>
<body>
<a href = "countries.jsp">Back</a><br/><br/>
<%
String countryId = request.getParameter("country_id");
countryController.setSelectedCountry(Integer.valueOf(countryId));
%>

<form action="addCountry" method="post"> 
	<label for="country_name">Country name:</label>
	<input name="country_name" value = "${countryController.selectedCountry.name}" type="text"/><br/>
	<label for="phone">Phone:</label>
	<input name="phone" value = "${countryController.selectedCountry.phone}" type="text"/><br/>
	<input name="country_id" value = "${countryController.selectedCountry.id}" type="hidden"/>
	<input value="Save" type="submit"/>
</form>

</body>
</html>