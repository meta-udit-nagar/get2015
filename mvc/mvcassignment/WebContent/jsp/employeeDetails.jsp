<%@page import="com.model.Employee"%>
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

  Employee employee= (Employee)request.getAttribute("employee");
%>
Employee Id= <%=employee.getEmployeeId()%><br>
Name= <%=employee.getName()%><br>
Email= <%=employee.getEmail()%><br>
Age= <%=employee.getAge()%><br>
Date Of Registration= <%=employee.getDateOfRegistration()%><br>


<a href="/mvcassignment1/DoPrepareForm?id=-1">Register Here</a>
</body>
</html>