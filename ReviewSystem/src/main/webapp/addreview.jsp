<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add reviews</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
	Hello ${lb.user.firstName}<br><br>
	<br>
	<jsp:useBean id="arb" class="com.sunbeam.beans.AddReviewBean"/>
	${arb.findAllMovies()}
		
	<form method="post" action="addreviewintable.jsp">
	Movie:<select name="id" id="id">
				 <c:forEach var="c" items="${arb.movieList}">
				 <option value="${c.id}" >${c.name}</option>
				 </c:forEach>
				</select><br><br>
	Review:<textarea name="review"></textarea><br><br>
	Rating:<input type="number" name="rating"/><br><br>
	<input type="submit" value="Add Review"/>
	</form>
		
</body>
</html>