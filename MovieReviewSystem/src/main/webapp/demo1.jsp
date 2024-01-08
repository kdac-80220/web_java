
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
	private int count=0;
	
	public void jspInit()
	{
		System.out.println("demo1 jsp init called---");
	}
	public void jspDestroy()
	{
		System.out.println("demo1 jsp destroy called---");	
	}
	%>
	
	<%
		System.out.println("demo1 jsp service called---");
		out.println("Time: "+ new Date().toString());
	%>
	
	<%
		count++;
	out.println("Count: "+count);	
	%>
</body>
</html>