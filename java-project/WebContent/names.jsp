<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.controller.NameController" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:useBean id="nameController" class="com.controller.NameController"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Names</title>
</head>
<body>

<a href="add_name.jsp">Add name</a><br/><br/>
<form action="deleted_name.jsp" method="post">
<table border="1"> 
	<c:forEach var="name" items="${nameController.names}"> 
		<tr>
			<td><c:out value="${name.id}"/></td>
			<td><c:out value="${name.name}"/></td>
			<td>&nbsp;<input name="name_id${name.id}" type="submit" value="Delete"/>&nbsp;</td>
		</tr>
	</c:forEach>  
</table> 
</form>
</body>
</html>