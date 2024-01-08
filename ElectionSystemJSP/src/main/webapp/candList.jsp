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
	
	
	<jsp:useBean id="cb" class="com.sunbeam.beans.CandidateBean"/>
	${cb.getCandidateList()}
	
	<div align="center">
	Hello ${lb.user.firstName}
		<form method="post" action="vote.jsp">
	<table border="1">
		<thead>
			<tr>
				<th>Choose</th>
				<th>Name</th>
				<th>Party</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="c" items="${cb.candList}">
			<tr><td><input type="radio" name="candidate" value="${c.id}"/></td><td>${c.name}</td><td>${c.party}</td></tr>
		</c:forEach>
			<tr><td colspan="3" align="center"><input type="submit" value="Vote"/></td></tr>
		</tbody>
	</table>
	</form>
		
	</div>
	</body>
</html>