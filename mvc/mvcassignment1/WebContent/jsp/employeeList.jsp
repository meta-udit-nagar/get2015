<%@page import="com.model.Employee"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

    Map<Integer, Employee> listOfEmployee=(Map<Integer,Employee>)request.getAttribute("listOfEmployee");

for(int i:listOfEmployee.keySet())
{

out.print(listOfEmployee.get(i).getEmployeeId()+" ");
out.print(listOfEmployee.get(i).getName()+" ");
out.print(listOfEmployee.get(i).getEmail()+" ");
%>
<a href="/mvcassignment1/DoGetDetails?id=<%=i%>">View Detail</a>&nbsp;<a href="/mvcassignment1/DoPrepareForm?id=<%=i%>">Edit</a>
<br>
<%
}
%>
</body>
</html>