<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring Prototype</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
</head>
<body>
	<div id="body">
		<!-- top shadow start -->
		<div id="topShadow"></div>
		<!-- top shadow end -->
		<!-- body panel start -->
		<div id="bodyPannel">

			<div id="">
				<h1>Timetable System</h1>
				<form:form method="POST" commandName="user" action="login2Submit">
					<table>
						<tr>
							<td>Username:</td>
							<td><form:input path="username"></form:input></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><form:input type="password" path="password"></form:input></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Login"></td>
						</tr>
					</table>
				</form:form>
			</div>
			<br class="spacer" />

		</div>
		<!-- body panel end -->
		<!-- top shadow start -->
		<div id="bottomShadow"></div>
		<br class="spacer" />
		<!-- bottom shadow end -->
	</div>
	<!-- body end -->
	<!-- footer start -->
	<div id="footer">
		<p>©TeamSourceCode. All rights reserved.</p>
		<br class="spacer" />
	</div>
	<!-- footer end -->

</body>
</html>