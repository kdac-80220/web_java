<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"/>
	<jsp:setProperty property="password" name="lb" param="passwd"/>
	<jsp:setProperty property="email" name="lb" param="email"/>
	<jsp:setProperty property="status" name="lb" value="false"/>
	<% lb.authenticate(); %>
	Login status: <jsp:getProperty property="status" name="lb"/>
	
    <%
    	if(lb.getStatus())
    	{
    		out.println("Login Successful");
    	}
    	else{
    		out.println("Login Failed");	
    	}
    %>
</body>
</html>