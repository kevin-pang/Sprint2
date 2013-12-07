<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Teaching Session</title>
</head>
<body>
	<h1>New Teaching Session</h1>
	<table>
		<tfoot>
			<tr>
				<td></td>
				<td align="right">
						<input type="submit" value="Submit">
						<input type="submit" value="Back">
				</td>
			</tr>
		</tfoot>
		<tr>
			<td>Title:</td>
			<td>${ts.title}</td>
		</tr>
		<tr>
			<td>Date:</td>
			<td>${ts.startDate}</td>
		</tr>
		<tr>
			<td>Time:</td>
			<td>${ts.startTime}</td>
		</tr>
		<tr>
			<td style="width: 212px;">Duration:</td>
			<td>${ts.duration}</td>
		</tr>
		<tr>
			<td>Repeat Frequency:</td>
			<td>${ts.repeatFrequency}</td>
		</tr>
		<tr>
			<td>Lecturer:</td>
			<td>${ts.lecturer}</td>
		</tr>
		<tr>
			<td>Max Attendance:</td>
			<td>${ts.maxAttendance}</td>
		</tr>
		<tr>
			<td>Compulsory:</td>
			<td>${ts.compulsory}</td>
		</tr>
		<tr>
			<td>Venue:</td>
			<td>${ts.venue}</td>
		</tr>
	</table>
</body>
</html>