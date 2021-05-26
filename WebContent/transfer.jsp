<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer</title>
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
<br>
<center>
<h1>${msg }</h1>
<h1>${bal }</h1>
<h1>Recipient  Form</h1>
<form action="add/${cid }" method="post">
 <table align="center" cellpadding="10" style="font-family:serif">
 
 <tr>
 <tr> <td align="center" colspan="2"><h3>Recipient Details <h3></h1></button></tr>
 <th>Recipient Account Number: </th>
 <td><input type="text" name="accn2"></td>
 </tr>
 <tr>
 <th>Account Holder Name: </th>
 <td><input type="text" name="name"></td>
 </tr>
 <tr>
 <th>Account Type:</th>
 <td><input type="radio" name="type" value="savings">Savings  <input type="radio" value="primary"  name="type">Primary </td>
 </tr>
 <tr>
 <th>Mobile Number: </th>
 <td><input type="text" name="mobile"></td>
 </tr>
 <tr></tr>
<br>
<tr>
<td align="center" colspan="2"><button type="submit" value="Submit">Add Recipient</button>
</tr>
 </table>
  <br>
</body>
</html>