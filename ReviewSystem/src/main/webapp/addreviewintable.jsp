<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add review</title>
</head>
<body>
	<jsp:useBean id="anrb" class="com.sunbeam.beans.AddReviewBean"/>
	<jsp:setProperty property="movieId" name="anrb" param="id"/>
	<jsp:setProperty property="userId" name="anrb" value="${lb.user.id}"/>
	<jsp:setProperty property="rating" name="anrb" param="rating"/>
	<jsp:setProperty property="review" name="anrb" param="review"/>
	
	${anrb.addReview()}
	
	<c:redirect url="review.jsp"/>
	
</body>
</html>