<%@page import="com.helper.EmployeeHelper"%>
<%@page import="com.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	${content}
	<br>
	<a href="/mvcassignment1/ShowList">List Of Employee</a>
	<br>
	<a href="/mvcassignment1/DoPrepareForm?id=-1">Register Employee</a>
</body>
</html>