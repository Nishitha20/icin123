<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
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
<body >
<jsp:include page="bankheader.jsp"></jsp:include>
<center>
<form action="bankregister" method="post">
<h3>
<table align="center" cellpadding="10" >
<tr>
<th>First Name </th>
<td><input type="text" name="fname"></td>
</tr>
<tr>
<th>Last Name </th>
<td><input type="text" name="lname"></td>
</tr>
<tr>
<th>User Name </th>
<td><input type="text" name="uname"></td>
</tr>
<tr>
<th>Password </th>
<td><input type="password" name="psswd"></td>
</tr>
<tr>
<th>Date of Birth </th>
<td><input type="date" name="dob"></td>
</tr>
<tr>
<th>Gender</th>
<td><input type="radio" name="gender" value="male">Male  <input type="radio" value="female"  name="gender">Female </td>
</tr>
<tr>
<th>Email  </th>
<td><input type="text" name="email"></td>
</tr>
<tr>
<th>Mobile</th>
<td><input type="text" name="mobile"></td>
</tr>
<tr>
<th>Address  </th>
<td><textarea type="text" name="address"></textarea></td>
</tr>
<tr>
<th>Account Type </th>
<td><input type="radio" name="type" value="savings">Savings  <input type="radio" value="primary"  name="type">Primary </td>
</tr>
<tr></tr>
<tr>
<td align="center" colspan="2"><button type="submit" value="Submit">Register</button>
</tr>
</table>
</center>
</h3>
</form>
<jsp:include page="bankfooter.jsp"></jsp:include>
</body>
</html>