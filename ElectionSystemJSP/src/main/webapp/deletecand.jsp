<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="cdb" class="com.sunbeam.beans.DeleteCandidateBean"/>
	<jsp:setProperty name="cdb" property="candId" param="id"/>
	${cdb.deleteCandidate()}
	<jsp:forward page="result.jsp"/>
</body>
</html>