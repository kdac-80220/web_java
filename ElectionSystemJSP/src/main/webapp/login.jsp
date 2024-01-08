<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty property="email" name="lb" param="email"/>
	<jsp:setProperty property="password" name="lb" param="password"/>
	<jsp:setProperty property="status" name="lb" param="false"/>
	${lb.authenticate()}
	Login status:<jsp:getProperty property="status" name="lb"/>
	${lb.user.getId()}
	
	<c:choose>
		<c:when test="${empty lb.user}">
			Invalid email or password. <br/><br/>
			<a href="index.jsp">Login Again</a>
		</c:when>
		<c:when test="${lb.user.role == 'admin'}">
			<c:redirect url="result.jsp"/>
		</c:when>
		<c:when test="${lb.user.role == 'voter'}">
			<c:redirect url="candList.jsp"/>
		</c:when>
		<c:otherwise>
			<c:redirect url="index.jsp"/>
		</c:otherwise>
	</c:choose>
</body>
</html>