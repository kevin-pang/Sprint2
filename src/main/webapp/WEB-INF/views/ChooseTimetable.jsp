<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Timetable</title>
</head>
<body>
	<form:form method="POST" commandName="tth" action="AddSession">
	<table>
		<tr>
			<td>Timetable:</td>
			<td><form:select path="timetableTitle" items="${timetableMap}"></form:select></td>
<%-- 			<td><form:select path="timetableTitle" items="${venueMap}"></form:select></td> --%>
		</tr>
		<tr>
					<td colspan="2"><input value="Submit" type="submit"></td>
				</tr>
	</table>
	</form:form>
</body>
</html>