<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Role" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="roleController" class="com.controller.RoleController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saved role</title>
</head>
<body>
<%
String roleName = request.getParameter("user_role");
Role role = new Role();
role.setName(roleName);
Role savedRole = roleController.save(role);
%>
Role "<%= savedRole.getName()%>" was saved successfully.
<br/>
<a href="roles.jsp">Roles</a><br/><br/>
</body>
</html>