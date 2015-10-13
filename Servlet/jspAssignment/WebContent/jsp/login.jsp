<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link href="../css/formCss.css" rel="stylesheet" />
</head>
<body>
	<form method="post" action="../DoLogin">
	
		<div class="form">
			<div class="form_heading">Registration</div>
			<table cellspacing="10">
				
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input type="email" name="email"></td>
				</tr>


				
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>
				</tr>
								<tr>
					<td><input type="submit" name="submit" value="Login"
						class="btn"></td>
				</tr>

			</table>

		</div>
	</form>
</body>
</html>