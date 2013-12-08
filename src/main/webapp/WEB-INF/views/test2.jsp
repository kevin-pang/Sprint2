<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person page</title>
</head>
<body>
<h1>Person page</h1>
<p>This is Person page</p>
<form:form method="POST" commandName="test-entity" action="process-test2.html">
<table>
    <tr>
        <td><form:label path="title">Title:</form:label></td>
        <td><form:input path="title" /></td>
    </tr>
    <tr>
        <td><form:label path="lecturer">Lecturer:</form:label></td>
        <td><form:input path="lecturer" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
        <td></td>
        <td></td>
    </tr>
</table>  
</form:form>
</body>
</html>