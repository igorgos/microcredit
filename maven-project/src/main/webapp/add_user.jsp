<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
<a href = "users.jsp">Back</a><br/><br/>
	<form action = "saved_user.jsp" method = "post">
	<label for="user_name">User name:</label>
	<input name = "user_name" type = "text"><br/>
	<input value="Save" type="submit"/>
	</form>
</body>
</html>