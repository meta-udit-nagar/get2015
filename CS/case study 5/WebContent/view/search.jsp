<!DOCTYPE html>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

	<%
		List<String> listOfMake = (List<String>) session
				.getAttribute("listOfMake");
		System.out.println(listOfMake.toString());
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

	</nav>
	<section id="about_login">
		<div id="form">
			<div class="form_heading">Login</div>
			<form action="/cardekho.com/DoSearch" method="post">
				<table cellspacing="10px">
					<tr>
						<td>Company</td>
						<td>:</td>
						<td><select required class="searchBox" name="make">
								<option selected disabled value="">-Select-</option>

								<%
									for (String make : listOfMake) {
								%>
								<option value="<%=make%>"><%=make%></option>
								<%
									}
								%>

						
					<tr>
						<td><input type="submit" name="submit" class="btn"
							value="Submit"></td>
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