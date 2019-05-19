<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.controller.HobbyController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="hobbyController" class="com.controller.HobbyController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hobbies</title>
</head>
<body>

<a href="add_hobby.jsp">Add hobby</a><br/><br/>
<form action="deleted_hobby.jsp" method="post">
<table border="1"> 
	<tr>
		<td>Id hobby</td>
		<td>Denumire</td>
		<td>Persoane</td>
	</tr>
	<c:forEach var="hobby" items="${hobbyController.hobbies}"> 
		<tr>
			<td><c:out value="${hobby.id}"/></td>
			<td><c:out value="${hobby.name}"/></td>
			<td>
			<c:forEach var="user" items="${hobby.users}">
				<c:out value="${user.name}"/>
			</c:forEach>
			</td>
			<td>&nbsp;<input name="hobby_id${hobby.id}" type="submit" value="Delete"/>&nbsp;</td>
		</tr>
	</c:forEach>  
</table>  
</form>
</body>
</html>