<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="register.jsp">
		<table>
			<tbody>
				<tr><td>First Name</td><td><input type="text" name="firstName"/></td></tr>
				<tr><td>Last Name</td><td><input type="text" name="lastName"/></td></tr>
				<tr><td>Email</td><td><input type="text" name="email"/></td></tr>
				<tr><td>Password</td><td><input type="text" name="password"/></td></tr>
				<tr><td>Mobile</td><td><input type="text" name="mobile"/></td></tr>
				<tr><td>Birth Date</td><td><input type="date" name="birthdate"/></td></tr>
				<tr><td><input type="reset" value="Clear"/></td><td><input type="submit" value="Submit"/></td></tr>
			</tbody>
		</table>
	</form>
</body>
</html>