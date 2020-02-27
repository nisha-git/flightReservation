<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
   <h4>${msg }</h4>
	<h1>Login Here</h1>
	<form action="login" method="POST">
	 <pre>
	   email : <input type="text" name="email" />
       password : <input type="password" name="password" />  
       <input type="submit" value="Login">
      </pre>
	</form>
</body>
</html>