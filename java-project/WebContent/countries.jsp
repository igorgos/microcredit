<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="countryController" class="com.controller.CountryController" />
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Countries</title>
</head>
<body>

<a href="add_country.jsp">Add country</a><br/><br/>
<form action="deleted_country.jsp" method="post">
	<br/>
		<table border="1">
			<c:forEach var="country" items="${countryController.countries}">
				<tr>
					<td><c:out value="${country.id}" /></td>
					<td><c:out value="${country.name}" /></td>
					<td>
						<form action="delete_country.jsp" method="post">
							<input name="country_id" type="hidden" value="${country.id}"/>
							&nbsp;<input id ="${country.id}" type="submit" value="Delete"/>&nbsp;
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
</form>  
</body>
</html>