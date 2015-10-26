<!DOCTYPE html>
<%@page import="com.metacube.model.Car"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script>
	function setroadTax() {

		document.getElementById("roadTax").value = (document
				.getElementById("showroomPrice").value * 5) / 100;

	}
	function setroadPrice() {

		document.getElementById("roadPrice").value = Number((document
				.getElementById("showroomPrice").value))
				+ Number((document.getElementById("roadTax").value))

	}
</script>
</head>
<body>


<%

        if(session.getAttribute("id")==null)
        {
        	response.sendRedirect("login.jsp");
        	
        }


%>
	<header>
		Car Dekho<span id="com">.com</span>
	</header>
	<section id="home_image"></section>
	<nav>
		<ul>
			<li><a href="homepage.jsp">Home</a></li>
			<li><a href="search.jsp">Search</a></li>
		</ul>
<% 

          Car car=  (Car)session.getAttribute("car");
           
          int vehicle_id=(Integer)session.getAttribute("vehicle_id");

%>
	</nav>
	<section id="about_create">
		<div id="form">
			<div class="form_heading">Create</div>
			<form action="/cardekho.com/DoEdit" method="post">
				<table cellspacing="10px">
					<tr>
						<td>Company</td>
						<td>:</td>
						<td><input type="text" id="company" name="company" value="<%=car.getMake()%>"></td>
					</tr>
					<tr>
						<td>Model</td>
						<td>:</td>
						<td><input type="text" id="model" name="model" value="<%=car.getModel() %>"></td>
					</tr>
					<tr>
						<td>EngineInCC</td>
						<td>:</td>
						<td><input type="number" id="engineInCc" name="enginInCc" value="<%=car.getEnginInCC()%>" required></td>
					</tr>
					<tr>
						<td>FuelCapacity</td>
						<td>:</td>
						<td><input type="number" id="fuelCapacity" name="fuelCapacity" value="<%=car.getFuelCapacity()%>" required></td>
					</tr>
					<tr>
						<td>Milage</td>
						<td>:</td>
						<td><input type="number" id="milage" name="milage" value="<%=car.getMilage()%>" required></td>
					</tr>
					<tr>
						<td>AC</td>
						<td>:</td>
                         <td><select name="ac">
						<option value="true">true</option>
						<option value="false">false</option>
						</select></td>
					</tr>
					<tr>
						<td>Power Stearing</td>
						<td>:</td>
						<td><select name="powerStearing">
						<option value="true">true</option>
						<option value="false">false</option>
						</select></td>
					</tr>
					<tr>
						<td>Accessory Kit</td>
						<td>:</td>
						<td><select name="accessoryKit">
						<option value="true">true</option>
						<option value="false">false</option>
						</select></td>
					</tr>
					<tr>
						<td>Ex-showroomPrice</td>
						<td>:</td>
						<td><input type="number" id="showroomPrice"
							name="showroomPrice" required></td>
					</tr>
					<tr>
						<td>RoadTax</td>
						<td>:</td>
						<td><input type="number" id="roadTax" name="roadTax"
							onclick="setroadTax()" required readonly></td>
					</tr>
					<tr>
						<td>OnRoadPrice</td>
						<td>:</td>
						<td><input type="number" id="roadPrice" name="roadPrice"
							 onclick="setroadPrice()" value="<%=car.getPrice()%>" required></td>
					</tr>
					<tr>
					  <input type="hidden" name="vehicle_id" value="<%=vehicle_id%>">

						<td><input type="submit" name="submit" class="btn"></td>
					</tr>



				</table>

			</form>
		</div>
		.
	</section>
	<footer>
		Home|Search|Create <br /> Copyright © 2015. All rights Reserved.
	</footer>
</body>
</html>