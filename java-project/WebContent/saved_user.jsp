<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="userController" class="com.controller.UserController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saved user</title>
</head>
<body>
<%
String userName = request.getParameter("user_name");
User user = new User();
user.setName(userName);
User savedUser = userController.save(user);
%>
User "<%= savedUser.getName()%>" was saved successfully.
<br/>
<a href="users.jsp">Users</a><br/><br/>
</body>
</html>