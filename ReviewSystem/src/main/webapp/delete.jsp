<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="db" class="com.sunbeam.beans.DeleteBean"/>
	<jsp:setProperty property="id" name="db" param="id"/>
	${db.deleteReview()}
	<c:redirect url="review.jsp"/>
</body>
</html>