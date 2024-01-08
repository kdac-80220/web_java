<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<%--
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegisterBean" />
	<jsp:setProperty name="rb" property="*"/>
	<jsp:setProperty property="status" name="rb" value="false"/>
	
	<% rb.registerUser(); %>
	
	Login Status:<jsp:getProperty property="status" name="rb"/>
	
	<%
		if(rb.getStatus())
		{
			out.println("Registration Successful");
		}
		else{
			out.println("Registration unsuccessful");
		}
	%>
	--%>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegisterBean"/>
	<jsp:setProperty property="*" name="rb"/>
	<jsp:setProperty property="status" name="rb" value="false"/>
	
	<% rb.registerUser(); %>
	
	Login Status:<jsp:getProperty property="status" name="rb"/>
	
	<%
		if(rb.getStatus())
		{
			out.println("Data added successfully");	
		}
		else{
			out.println("Error occured");	
		}
	%>
</body>
</html>