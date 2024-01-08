<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Review</title>
</head>
<body>
	<div class="container">
		Hello ${lb.user.firstName}
	<jsp:useBean id="rb" class="com.sunbeam.beans.ReviewBean"/>
	
	
	
	
	
	
	<nav class="navbar navbar-inverse">
  	<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="review.jsp">Movie Review System</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="myreview.jsp">My Review</a></li>
      <li><a href="addreview.jsp">Add Review</a></li>
    </ul>
  	</div>
	</nav>
	
	
	
	
	
	
	
	
	
	
	
	<%-- 
  	<button><a href="myreview.jsp">My Review</a></button>
	
	<button><a href="addreview.jsp">Add Review</a></button>
  	--%>
	
	${rb.getResultList()}
	
	<center>
	<h1>All reviews</h1>
	<div class="jumbotron">
		
		<table class="table table-striped table-dark">
		<thead class="thead-dark">
			<tr>
			<th>Id</th>
			<th>MovieID</th>
			<th>Review</th>
			<th>Rating</th>
			<th>UserId</th>
			<th>Movie Name</th>
			<th>Date Modified</th>
			<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${rb.reviewList}" >
			<tr>
			<td>${c.id}</td>
			<td>${c.movieId}</td>
			<td>${c.review}</td>
			<td>${c.rating}</td>
			<td>${c.userId}</td>
					<td>
					<c:forEach var="m" items="${rb.movieList}">
						<c:if test="${c.movieId == m.id}">
						${m.name}
						</c:if>
					</c:forEach>
					</td>
			<td>${c.modified}</td>
			<td>
			<c:choose>
				<c:when test="${c.userId == lb.user.id }">
					<a href="edit.jsp?id=${c.id}"><img alt="edit" src="edit.png" height="35px" width="35px"></a> 
					<a href="delete.jsp?id=${c.id}"><img alt="delete" src="delete.png" height="35px" width="35px"></a>
				</c:when>
				<c:otherwise>
					Not allowed
				</c:otherwise>
			</c:choose>
				
			</td>
			</tr>
			</c:forEach>	
		</tbody>
	</table>
	
	</div>
	</center>
	</div>
	
</body>
</html>