<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Location" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="locationController" class="com.controller.LocationController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleted location</title>
</head>
<body>
<%
String locationId = request.getParameter("location_id2");

%>
Location "<%= locationId%>" was deleted successfully.
<br/>
<a href="locations.jsp">Locations</a><br/><br/>
</body>
</html>