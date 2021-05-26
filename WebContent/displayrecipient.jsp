<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
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
.button 
{
    display: block;
    width: 250px;
    height: 25px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    line-height: 25px;
    text-decoration:none;
    font-size:20px;
}
</style>
</head>
<body>
<body >
	<center>
	<h1>${msg }</h1>
	<br><br>
	<h1>Existing Recipients</h1>
	<br>
	<table align="center" cellpadding="10" border="2">
		<tr>
			<th>Account Number</th>
			<th>Name</th>
			<th>Account Type</th>
			<th>Mobile</th>
			<th>Action</th>
		</tr>
		<c:forEach var="t" items="${tlist}">
			<tr>
				<td>${t.acnum}</td>
				<td>${t.acname}</td>
				<td>${t.actype}</td>
				<td>${t.mobile}</td>
				<td><a href="transfer2/<c:out value='${cid}'/>/<c:out value='${t.acnum}'/>">Transfer</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
	<br><br>
	
		<a class="button" href="transfer1/${cid }" target="f2">Add New Recipients</a>
</body>
</html>