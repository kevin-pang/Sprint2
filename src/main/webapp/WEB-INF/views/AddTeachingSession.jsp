<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Teaching Session</title>
</head>
<body>
	<h1>Add Teaching Session</h1>
	<form:form method="POST" commandName="tsh" action="AddSession2">
		<table>
			<tr>
				<c:choose>
					<c:when test="${tsMap.size == 0}">
						<td colspan="2"><font color="red">No New Session to
								Add!</font></td>

					</c:when>
					<c:otherwise>
						<td>Teaching Session:</td>
						<td><form:select path="title" items="${tsMap}"></form:select></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td colspan="2"><input value="Submit" type="submit"><input type="button" onclick="history.back();" value="Back"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>