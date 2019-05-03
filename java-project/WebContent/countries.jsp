<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.controller.CountryController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="countryController" class="com.controller.CountryController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Time: <c:out value="${countryController.time}"/><br/> 
<table border="1"> 
	<c:forEach var="country" items="${countryController.countries}"> 
		<tr><td><c:out value="${country.id}"/></td><td><c:out value="${country.name}"/></td></tr>
	</c:forEach>  
</table>  
</body>
</html>