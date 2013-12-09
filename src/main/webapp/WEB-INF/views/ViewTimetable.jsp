<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Timetable: ${tt.title}</h1>
	<a href="/ge1/">Logout</a>
	<h2>Teaching Sessions</h2>
	<table border="1">
		<tr>
			<th>Title</th>
			<th>Start Date</th>
			<th>Time</th>
			<th>Duration</th>
			<th>Venue</th>
			<th>Repeat Frequency</th>
			<th>Lecturer</th>
		</tr>
		<c:forEach items="${tt.teachingSessions}" var="ts">
			<tr>
				<td>${ts.title}</td>
				<td>${ts.startDate}</td>
				<td>${ts.startTime}</td>
				<td>${ts.duration}</td>
				<td>${ts.venue}</td>
				<td>${ts.repeatFrequency}</td>
				<td>${ts.lecturer}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>