<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
<style>


body
{
 background : linear-gradient(120deg,#2980b9,#8e44ad)
}

</style>
</head>
<body>
<body >
<h1>${msg }
${bal }</h1>
<h2>
	<center>
	<br><br><br><br>
		<c:forEach var="t" items="${tlist}">
				Account Number : ${t.acnum}<br>
				Account Name   : ${t.acname}<br>
				Account Type   : ${t.actype}<br>
				Mobile         : ${t.mobile}<br>
				
		
		
	<br><br><br><br>
	<form action="add1/<c:out value='${t.acnum}'/>/<c:out value='${t.acname}'/>/<c:out value='${t.actype}'/>/<c:out value='${t.mobile}'/>" method="post">
	<table>
	<tr><td>Enter Amount to Transfer :</td><td><input type="text" name="amount"></td>
	<tr><td>Enter Password           :</td><td><input type="password" name="psswd"></td>
	<tr><td colspan="2" align="center"><input type="submit" value="Transfer" name="Transfer"></td>
	</c:forEach>
	</form>
	</table>
	</center>
	</h2>
</body>
</html>