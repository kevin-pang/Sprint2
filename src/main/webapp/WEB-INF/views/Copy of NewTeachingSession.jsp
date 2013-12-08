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
	<a href="/login/">Logout</a>
	<form method="get" action="NewTeachingSessionSubmit">
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
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>Date:</td>
			<td><input type="date" name="startDate"></td>
		</tr>
		<tr>
			<td>Time:</td>
			<td><input type="time" name="startTime"v alue="24 Hour Format"></td>
		</tr>
		<tr>
			<td style="width: 212px;">Duration:</td>
			<td>1<input type="range" name="duration" min="1" max="10">10 (Hours)</td>
		</tr>
		<tr>
			<td>Repeat Frequency:</td> 
			<td><select name="repeatfreq" align="left">
				<option value="1">Once</option>
				<option value="2">Twice</option>
			    </select>
			</td>
		</tr>
		<tr>
			<td>Lecturer:</td>
			<td><select name="lecturer" align="left">
					<option value="Professor John">Professor John</option>
					<option value="Professor May">Professor May</option>
					<option value="Professor Ken">Professor Ken</option>
					<option value="Professor Kevin">Professor Kevin</option>
				</select></td>
		</tr>
		<tr>
			<td>Max Attendance:</td>
			<td><input type="number" name="maxAttendance" min="1" max="200"> (Min 1 Max 200)</td>
		</tr>
		<tr>
			<td>Compulsory:</td>
			<td><input type="checkbox" name="compulsory"></td>
		</tr>
		<tr>
			<td>Venue:</td>
			<td><select name="venue" align="left">
				<option value="lab">Lab</option>
				<option value="tutorial">Tutorial Room</option>
				</select>		
			</td>
		</tr>
	</table>
	</form>
</body>
</html>