<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Name" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="nameController" class="com.controller.NameController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saved name</title>
</head>
<body>
<%
String nameName = request.getParameter("name_name");
Name name = new Name();
name.setName(nameName);
Name savedName = nameController.save(name);
%>
Name "<%= savedName.getName()%>" was saved successfully.
<br/>
<a href="names.jsp">Names</a><br/><br/>
</body>
</html>