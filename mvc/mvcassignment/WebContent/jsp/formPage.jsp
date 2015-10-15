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
String employId="";
String name="";
String email="";
String age="";
String submitValue="Register";
String formAction="/mvcassignment1/DoRegister";
int id=-1;
Object employee=request.getAttribute("employee");
if(employee instanceof Employee)
{    
	Employee employee2=(Employee)employee;
	employId=""+employee2.getEmployeeId();
	name=employee2.getName();
	email=employee2.getEmail();
	age=""+employee2.getAge();
    submitValue="Edit";
    formAction="/mvcassignment1/DoEdit";
    id=(Integer)request.getAttribute("id");
}

%>


<form method="post" action="<%=formAction%>">
Employee Id= <input type="text" name="employId" value="<%=employId %>"><br>
Name= <input type="text" name="name" value="<%=name %>"><br>
Email= <input type="email" name="email" value="<%=email %>"><br>
Age= <input type="text" name="age" value="<%=age %>"><br>
<input type="submit" name="submit" value="<%=submitValue %>">
<input type="hidden" name="id" value="<%=id%>">
</form>

</body>
</html>