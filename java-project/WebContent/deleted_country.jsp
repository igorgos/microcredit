<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Country" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="countryController" class="com.controller.CountryController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saved country</title>
</head>
<body>
<%
String countryId = request.getParameter("country_id3");

%>
Country "<%= countryId%>" was deleted successfully.
<br/>
<a href="countries.jsp">Countries</a><br/><br/>
</body>
</html>