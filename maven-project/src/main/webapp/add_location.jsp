<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Location</title>
</head>
<body>
<a href = "locations.jsp">Back</a><br/><br/>
	<form action="saved_location.jsp" method="post">
	<label for="location_name">Location name:</label>
	<input name="location_name" type="text"/><br/>
	<input value="Save" type="submit"/>
	</form>
</body>
</html>