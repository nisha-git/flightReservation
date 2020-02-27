<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>
	<h1>Register Here</h1>

<h3>${msg}</h3>

  <form action="register" method="post">
		<pre>
   First Name : <input type="text" name="firstName" />
   Last Name : <input type="text" name="lastName" />
   email : <input type="text" name="email" />
   password : <input type="password" name="password" />
   confirm Password : <input type="password" name="confirmPassword" />
         <input type="submit" value="Register">
 </pre>
	</form>
</body>
</html>