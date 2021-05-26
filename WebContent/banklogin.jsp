<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
<jsp:include page="bankheader.jsp"></jsp:include>
<br><br><br><br><br><br><br><br>
<center>
<h3>${msg }</h3>
<h1>Login</h1>
<form action="banklogin" method="post" >
<table  align="center" cellpadding="10">
<tr>
<th>Customer Id</th>
<td><input type="text" name="cid"></td>
</tr>

<tr>
<th>Password </th>
<td><input type="password" name="psswd"></td>
</tr>

<tr></tr>
<tr>
<td align="center" colspan="2"><button type="submit" value="Submit">Log In </button>
</tr>
</table>
</form>
</center>
<br><br><br><br><br><br><br><br><br><br>
<jsp:include page="bankfooter.jsp"></jsp:include>
</body>
</html>