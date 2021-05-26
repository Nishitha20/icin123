<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Cheque</title>
<style>
a
{
	padding:8px;
	color:white;
	font-family: Verdana, sans-serif;
}
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
	<h1>${msg }</h1>
	<table align="center" cellpadding="10" border="2">
		<tr>
			<th>Customer Id</th>
			<th>Account Number</th>
			<th>Name</th>
			<th>Account Type</th>
			<th>Address</th>
			<th>Mobile</th>
			<th>Deposit Permissions</th>
		</tr>
		<c:forEach var="b" items="${rlist}">
			<tr>
				<td>${b.cid}</td>
				<td>${b.acnum}</td>
				<td>${b.acname}</td>
				<td>${b.type}</td>
				<td>${b.address }</td>
				<td>${b.mobile}</td>
				<td><a href="rblock1/<c:out value='${b.cid}'/>">Grant</a>     
				<a href="rblock2/<c:out value='${b.cid}'/>">Deny</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>