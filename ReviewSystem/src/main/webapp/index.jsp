<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 class="text-success text-center"> 
        Movie Review System 
    </h1> 
    <div class="container mt-5 "> 
        <div class="row justify-content-center"> 
            <div class="col-md-6"> 
                <div class="card"> 
                    <div class="card-body"> 
                        <form id="registrationForm" action="login.jsp"> 
                            <div class="form-group"> 
                                <label for="email"> 
                                    Email 
                                </label> 
                                <input type="email" 
                                       class="form-control" 
                                       id="email" 
                                       name="email"
                                       placeholder="Email" required> 
                            </div> 
                            <div class="form-group"> 
                                <label for="password"> 
                                    Password 
                                </label> 
                                <input type="password"
                                       class="form-control" 
                                       id="password" 
                                       name="password"
                                       placeholder="Password" required> 
                            </div> 
                            <button class="btn btn-danger"> 
                                Login 
                            </button> 
                        </form> 
                        <p class="mt-3">Not registered? 
                            <a href="#">Create an account</a> 
                        </p> 
                    </div> 
                </div> 
            </div> 
        </div> 
    </div> 
	<%-- <div align="center" class="form-group">
		<form method="post" action="login.jsp">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="email" class="form-control"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" class="form-control"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Login"></td>
			</tr>
		</table>
		</form>
	</div>
	--%>
</body>
</html>