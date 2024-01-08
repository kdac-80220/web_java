<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty  name="lb" property="*"/>
	<jsp:setProperty property="status" name="lb" value="false"/>
	${lb.authenticate()}
	
	<c:redirect url="review.jsp"/>
	
	<br><br><br>
	<a href="logout.jsp">Logout</a>
</body>
</html>