<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="ecb" class="com.sunbeam.beans.EditCandidateBean"/>
	<jsp:setProperty name="ecb" property="candId" param="id"/>
	${ecb.EditCandidate()}
	<form method="post" action="update.jsp">
		Id:<input type="text" name="id" value="${ecb.candidate.id}"/><br><br>
		Name:<input type="text" name="name" value="${ecb.candidate.name}"/><br><br>
		Party:<input type="text" name="party" value="${ecb.candidate.party}"/><br><br>
		Votes:<input type="text" name="votes" value="${ecb.candidate.votes}"/><br><br>
		<input type="submit" value="Update candidate"/>
	</form>
</body>
</html>