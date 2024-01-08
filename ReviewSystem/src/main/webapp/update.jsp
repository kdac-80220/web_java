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
	Hello ${lb.user.firstName}
	
	<jsp:useBean id="ub" class="com.sunbeam.beans.UpdateBean"/>
	<jsp:setProperty name="ub"  property="id" param="id"/>
	<jsp:setProperty name="ub"  property="review" param="review"/>
	${ub.updateReview()}
	
	 <c:redirect url="review.jsp"/> 	
</body>
</html>