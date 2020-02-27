<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>flight</title>
</head>
<body>
	<h4>Search Flight</h4>

	<form action="findflight" method="get">
		From : <input type="text" name="from" /> To : <input type="text"
			name="to" /> Departure Date : <input type="text"
			name="departureDate" /> <input type="submit" value="Search" />
	</form>
 <br/> <br/> <br/> <br/> <br/>
	<table border="2">
		<tr>
			<th>Operating Airlines</th>
			<th>Flight Number</th>
			<th>Departure City</th>
			<th>Arrival City</th>
			<th>Departure Date</th>
			<th>Select</th>

		</tr>
		<c:forEach items="${flights }" var="flight">
			<tr>
				<td>${flight.operatingAirlines}</td>
				<td>${flight.flightNumber}</td>
				<td>${flight.departureCity}</td>
				<td>${flight.arrivalCity}</td>
				<td>${flight.dateOfDeparture}</td>
				<td><a href="select?flightId=${flight.id }">Select</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>