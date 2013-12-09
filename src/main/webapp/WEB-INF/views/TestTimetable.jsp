<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Timetable</title>
</head>
<body>
<h1></h1>
<form:form method="POST" commandName="timetable" action="AddTeachingSession">
	<table>
		<tr>
			<td>Title:</td>
			<td>${timetable.title}</td>
		</tr>
		<tr>
			<td>Teaching Sessions:</td>
			
			<td><c:forEach items="${timetable.teachingSessions}" var="ts">
					${ts.title}<br>
				</c:forEach></td>
		</tr>
		<tr>
		<td colspan="2"><input value="Add Teaching Session" type="submit"></td>
	</tr>
	</table>
</form:form>
</body>
</html>