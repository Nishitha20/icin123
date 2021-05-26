<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Cheque Book</title>
<style>
body
{
 background : linear-gradient(120deg,#2980b9,#8e44ad)
}
.button 
{
    display: block;
    width: 115px;
    height: 25px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    line-height: 25px;
}
a
{
text-decoration:none;
}
</style>
</head>
<body>
<center>
	<h1>Account Details for new Cheque Book</h1>
				<h3>Account Holder Name : ${acname} </h3>
				<h3>Account number : ${acnum}</h3>
				<h3>Account Type : ${type }</h3>
				<h3>Address : ${address }</h3>
				<h3>Mobile : ${mobile }</h3>
	
<h1> Are you sure to proceed ?</h1>
<a href="yes/${cid}" target="f2" class="button">Yes</a>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="no" target="f2" class="button">No</a>
</center>
</body>
</html>