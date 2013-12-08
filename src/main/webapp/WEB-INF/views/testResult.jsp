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
<table>
    <tbody><tr>
        <td>Title:</td>
        <td>${ts.title}</td>
    </tr>
    <tr>
        <td>Start Date:</td>
        <td>${ts.startDate}</td>
    </tr>
     <tr>
        <td>Start Time:</td>
        <td>${ts.startTime}</td>
    </tr>
     <tr>
        <td>Duration:</td>
        <td>${ts.duration}</td>
    </tr>
    <tr>
        <td>Repeat Frequency:</td>
        <td>${ts.repeatFrequency}</td>
    </tr>
    <tr>
        <td>Repeat Frequency:</td>
        <td>${ts.lecturer}</td>
    </tr>
    <tr>
        <td>Max Attendance:</td>
        <td>${ts.maxAttendance}</td>
    </tr>   
    <tr>
        <td>Compulsory</td>
        <td>${ts.compulsory}</td>
    </tr>  
    <tr>
        <td colspan="2">
            
        </td>
    </tr>
</tbody></table>  
</body>
</html>