<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AccountDetails</title>
<style>
body
{
 background : linear-gradient(120deg,#2980b9,#8e44ad)
}
</style>
</head>
<body>
<jsp:include page="bankheader.jsp"></jsp:include>
<br><br><br><br><br><br>
<center>
<h1>${msg }</h1>
<br><br>
 <h2>Account Details</h2>
 <br>
 <h3>
 Customer Id : ${cid }
 <br><br>
 Account Number : ${acnum }
 </h3>
</center>
<br><br><br><br><br><br>
<jsp:include page="bankfooter.jsp"></jsp:include>
</body>
</html>