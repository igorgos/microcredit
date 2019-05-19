<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Hobby" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="hobbyController" class="com.controller.HobbyController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saved hobby</title>
</head>
<body>
<%
String hobbyName = request.getParameter("hobby_name");
Hobby hobby = new Hobby();
hobby.setName(hobbyName);
Hobby savedHobby = hobbyController.save(hobby);
%>
Hobby "<%= savedHobby.getName()%>" was saved successfully.
<br/>
<a href="hobbies.jsp">Hobbies</a><br/><br/>
</body>
</html>