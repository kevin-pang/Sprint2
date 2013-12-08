<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Spring Prototype</title>
</head>
<body>
<h1>
	Timetable System  
</h1>
<form:form method="POST" commandName="user" action="login2Submit">
<table>
<tr>
<td>Username: </td>
<td><form:input path="username"></form:input></td>
</tr>
<tr>
<td>Password: </td>
<td><form:input type="password" path="password"></form:input></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Login"></td>
</tr>
</table>
</form:form>
</body>
</html>