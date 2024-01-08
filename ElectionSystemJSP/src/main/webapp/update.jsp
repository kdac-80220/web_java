<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="ub" class="com.sunbeam.beans.UpdateBean"/>
	<jsp:setProperty name="ub" property="*"/>
	${ub.updateCandidate()}
	
	<jsp:forward page="result.jsp"></jsp:forward>
</body>
</html>