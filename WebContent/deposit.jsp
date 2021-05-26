<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Amount</title>

<style>
body
{
 	background : linear-gradient(120deg,#2980b9,#8e44ad)
}
table
{
	color:white;
	background-color:rgb(8,48,80);
	border-collapse:collapse;
	font-family:serif;
}
</style>

</head>

<body>
<br><br><br><br><br>
<center>
<h1>${msg }</h1>
<form action="actiondeposit/${cid }" method="post">
<h1>Deposit Form</h1>
<br>
 <table align="center" cellpadding="10">
 <tr></tr>
 
 <th>Enter Amount to Deposit : </td>
 <td><input type="text" name="amount"></td>
 </tr>
 <th>Password: </td>
 <td><input type="password" name="psswd"></td>
 </tr>
 <tr></tr>
<br>
<tr>
<td align="center" colspan="2"><button type="submit" value="Submit">Deposit</button>
</tr>
 </table>
  <br><br><br><br><br><br><br>
</form>
</body>
</html>