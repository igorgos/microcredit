<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add country</title>
</head>
<body>
<a href = "countries.jsp">Back</a><br/><br/>

<form action="addCountry" method="post"> 
	<label for="country_name">Country name:</label>
	<input name="country_name" type="text"/><br/>
	<label for="phone">Phone:</label>
	<input name="phone" type="text"/>	
	<input value="Save" type="submit"/>
</form>
</body>
</html>