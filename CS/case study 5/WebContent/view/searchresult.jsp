<!DOCTYPE html>
<%@page import="com.metacube.db.helper.VehicleDbHelper"%>
<%@page import="com.metacube.model.Vehicle"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<header>
		Car Dekho<span id="com">.com</span>
	</header>
	<section id="home_image"></section>
	<nav>
		<ul>
			<li><a href="homepage.jsp">Home</a></li>
			<li><a href="search.jsp">Search</a></li>
		</ul>

	</nav>
	<section id="about_login">
		<table cellspacing="10px">
			<tr>
				<th>Company</th>
				<th>Model</th>
				<th>SubModel</th>
				<th>Edit</th>
			</tr>
			<% 
			  List<Vehicle> listOfVehicle= (List<Vehicle>)session.getAttribute("listofVehicle");
			    for(Vehicle vehicle: listOfVehicle)
			    {
			%>
			
			<tr>
				<td><%=vehicle.getMake() %></td>
				<td><%=vehicle.getModel() %></td>
				<td><%=vehicle.getPrice() %></td>
				<td><a href="/cardekho.com/DoEdit?id=<%=vehicle.getVehicle_id()%>">Edit</a></td>
			</tr>
			<%} %>
			</table>
	</section>
	<footer>
		Home|Search|Create <br /> Copyright © 2015. All rights Reserved.
	</footer>
</body>
</html>