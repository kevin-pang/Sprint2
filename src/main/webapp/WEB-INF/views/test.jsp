<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" commandName="ts" action="process-test.html">
		<table>
			<tbody>
				<tr>
					<td><form:label path="title">Title:</form:label></td>
					<td><form:input path="title"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="startDate">Start Date:</form:label></td>
					<td><form:input path="startDate"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="startTime">Start Time:</form:label></td>
					<td><form:input path="startTime"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="duration">Duration:</form:label></td>
					<td><form:select path="duration" items="${durationMap}"></form:select></td>
				</tr>
				<tr>
					<td><form:label path="repeatFrequency">Repeat Frequency:</form:label></td>
					<td><form:select path="repeatFrequency"
							items="${repeatFrequencyMap}"></form:select></td>
				</tr>
				<tr>
					<td><form:label path="lecturer">Lecturer:</form:label></td>
					<td><form:select path="lecturer"
							items="${lecturerMap}"></form:select></td>
				</tr>
				<tr>
					<td><form:label path="maxAttendance">Max Attendance:</form:label></td>
					<td><form:input path="maxAttendance"></form:input>(Min 1 Max 200)</td>
					
				</tr>
				<tr>
					<td><form:label path="compulsory">Compulsory:</form:label></td>
					<td><form:checkbox path="compulsory"></form:checkbox></td>
					
				</tr>
				<tr>
					<td colspan="2"><input value="Submit" type="submit"></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>