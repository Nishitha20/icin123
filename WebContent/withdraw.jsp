<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Amount</title>

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
<br><br><br><br>
<center>
<form action="withdraw/${cid }" method="post">
<h2>${msg } 
${bal }</h2>
<br>
<h1>Withdraw Form</h1>
 <table align="center" cellpadding="10" style="font-family:serif">
 <tr></tr>
 
 <th>Enter Amount to withdraw : </td>
 <td><input type="text" name="amount"></td>
 </tr>
 <th>Password: </td>
 <td><input type="password" name="psswd"></td>
 </tr>
 <tr></tr>
<br>
<tr>
<td align="center" colspan="2"><button type="submit" value="Submit">Withdraw </button>
</tr>
 </table>
  <br><br><br><br><br><br><br>
</form>
</body>
</html>