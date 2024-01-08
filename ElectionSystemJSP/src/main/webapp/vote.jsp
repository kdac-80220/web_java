<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>
	<jsp:setProperty name="vb" property="candId" param="candidate"/>
	<jsp:setProperty name="vb" property="userId" value="${lb.user.id}"/>
	${vb.doVoting()}
	<h4>${vb.message}</h4>
	<a href="logout.jsp">Sign out</a>
</body>
</html>