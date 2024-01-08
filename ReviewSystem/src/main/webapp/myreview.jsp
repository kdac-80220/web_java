<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Myreview</title>
</head>
<body>
	<div class="container">
		Hello ${lb.user.firstName}
	<jsp:useBean id="mrb" class="com.sunbeam.beans.MyReviewBean"/>
	<jsp:setProperty property="id" name="mrb" value="${lb.user.id}"/>
	${mrb.myReview()}
	
	
	<div class="jumbotron">
		<table class="table table-striped table-dark">
		<thead class="thead-dark">
			<tr>
				<th>Id</th>
				<th>Movie Name</th>
				<th>Review</th>
				<th>Date Modified</th>
				<th>Action</th>
				
			</tr>
		</thead>
		<tbody>
		<c:forEach var="c" items="${mrb.myReviewList}">
				<tr>
				<td>${c.id}</td>
				<td>
					<c:forEach var="a" items="${mrb.myMovieList}">
						<c:if test="${c.movieId == a.id }">
						${a.name}
						</c:if>
					</c:forEach>
				</td>
				<td>${c.review}</td>
				<td>${c.modified}</td>
				<td><a href="edit.jsp?id=${c.id}"><img alt="edit" src="edit.png" height="35px" width="35px"></a>
				<a href="delete.jsp?id=${c.id}"><img alt="delete" src="delete.png" height="35px" width="35px"></a></td>
			</tr>
		</c:forEach>	
		
		</tbody>
	</table>
	</div>
	
	</div>
	
</body>
</html>