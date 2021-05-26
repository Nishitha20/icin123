<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Transactions</title>
<style>
table
{
	color:white;
	background-color:rgb(8,48,80);
	border-collapse:collapse;
	font-family:serif;
}
body
{
 background : linear-gradient(120deg,#2980b9,#8e44ad)
}
</style>
</head>
<body>
<center>
	<br><br>
	<h1>Transactions</h1>
	<table align="center" cellpadding="10" border="1">
		<tr>
			<th align="center">Transaction Id</th>
			<th align="center">Date of Transaction</th>
			<th align="center">Time of Transaction</th>
			<th align="center">Paid To</th>
			<th align="center">Received From</th>
			<th align="center">Previous Balance</th>
			<th align="center">Amount of Transaction</th>
			<th align="center">Type of Transaction</th>
			<th align="center">Closing Balance</th>
		</tr>
		<c:forEach var="c1" items="${tlist}">
			<tr>
				<td align="center">${c1.tid}</td>
				<td align="center">${c1.date}</td>
				<td align="center">${c1.time}</td>
				<td align="center">${c1.to}</td>
				<td align="center">${c1.from}</td>
				<td align="center">${c1.pbal}</td>
				<td align="center">${c1.amt}</td>
				<td align="center">${c1.typetid}</td>
				<td align="center">${c1.cbal}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
</body>
</html>