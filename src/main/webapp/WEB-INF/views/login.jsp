<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spring Prototype</title>
</head>
<body>
<h1>
	Timetable System  
</h1>
<form method="get" action="loginSubmit">
<table>
<tr>
<td>Username: </td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Password: </td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Login"></td>
</tr>
</table>
</form>
</body>
</html>