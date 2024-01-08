<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	Hello ${lb.user.firstName}
	
	<jsp:useBean id="frb" class="com.sunbeam.beans.FindReviewBean"/>
	
	<jsp:setProperty name="frb" property="id" param="id"/>
	${frb.findReview()}
	
	<form method="post" action="update.jsp">
		<input type="hidden" name="id" value="${frb.reviewPojo.id}">
		<table>
			<tr><td>Review</td><td><input type="text" name="review" value="${frb.reviewPojo.review}"/></td></tr>
		</table>
		<input type="submit" value="Update"/>
	</form>
</body>
</html>