<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
<link href="../css/formCss.css" rel="stylesheet" />
</head>
<body>
	<form method="post" action="../DoAddUser">
		<div class="form">
			<div class="form_heading">Registration</div>
			<table cellspacing="10">
				<tr>
					<td>Name</td>
					<td>:</td>
					<td><input type="text" name="name"></td>

				</tr>

				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input type="email" name="email"></td>
				</tr>


				<tr>
					<td>Date Of Birth</td>
					<td>:</td>
					<td><input type="text" name="dob"></td>
				</tr>

				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td>:</td>
					<td><input type="password" name="confirmPassword"></td>
				</tr>

				<tr>
					<td><input type="submit" name="submit" value="Submit"
						class="btn"></td>
				</tr>

			</table>

		</div>
	</form>
</body>
</html>