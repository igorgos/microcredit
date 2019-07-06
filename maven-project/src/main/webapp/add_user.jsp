<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="roleController" class="com.controller.RoleController"/>
<jsp:useBean id="hobbyController" class="com.controller.HobbyController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add user</title>
</head>
<body>
<form action="addUser" method="post">
<table border="0">
<tr>
	<td><label for="user_name">User name:</label></td>
	<td><input name="user_name" type="text"/></td>
</tr>

<tr>
	<td><label for="user_address">User address:</label></td>
	<td><input name="user_address" type="text"/></td>
</tr>

<!-- <tr>
	<td><label for="user_birthDate">User BirthDate:</label></td>
	<td><input name="user_birthDate" type="text"/></td>
</tr>
 -->
<tr>
	<td><label for="user_role">User role:</label></td>
	<td>
	<select name="user_role">
		<c:forEach var="role" items="${roleController.roles}">
			<option value="${role.id}"><c:out value="${role.name}"/></option>
		</c:forEach>
	</select>
	</td>
</tr>
<tr>
	<td><label for="user_hobby">User hobby:</label></td>
	<td>
	<select name="user_hobby">
		<c:forEach var="hobby" items="${hobbyController.hobbies}">
			<option value="${hobby.id}"><c:out value="${hobby.name}"/></option>
		</c:forEach>
	</select>
	</td>
</tr>
</table>
<input value="Save" type="submit"/>

</form>

</body>
</html>