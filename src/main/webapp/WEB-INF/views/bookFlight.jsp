<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Flight</title>
</head>
<body>
  <h1>Please Fill The Details!!</h1>
  
  <form action="bookFlight" method="post">
   
   	<pre>
   	<h3>Passenger Details...</h3>
   <input type="hidden" name="flightId" value="${flightId }">
   First Name : <input type="text" name="firstName" />
   Middle Name : <input type="text" name="middleName" />
   Last Name : <input type="text" name="lastName" />
   email : <input type="text" name="email" />
   phone : <input type="text" name="phone" />
   
   <h3>Card Details...</h3>
   Card Number : <input type="text" name="cardNumber" />
   Card Holder Name : <input type="text" name="cardHolderName" />
   Expiry Date : <input type="text" name="expiryDate" />
         
         <input type="submit" value="Book Now">
         </pre>
  </form>
</body>
</html>