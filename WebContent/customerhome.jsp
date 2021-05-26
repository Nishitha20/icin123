<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home Page</title>
<style>
.header a
{
	text-decoration : none;
	padding:8px;
	color:white;
	font-family: Verdana, sans-serif;
}
.header
{
	width:1306px;
	padding:20px;
	background:black;
	color:white;
}
section
{
	width:100%;
	float:left;
	height:520px;
}

.cen::after
{
	content:"";
	clear:both;
	display:table;
}
.footer
{
	width:1306px;
	padding:20px;
	background:black;
	color:white;
	font-family: Verdana, sans-serif;
}
f2
{
content:"";
	clear:both;
	display:table;
}

</style>
</head>
<body>
<div class="header">
<b>
 	<a href="customerheader.jsp" target="f2">Home</a>&nbsp&nbsp
 	<a href="balance/<c:out value='${cid}'/>" target="f2">Account Balance</a>&nbsp&nbsp
 	<a href="withdrawblock/<c:out value='${cid}'/>" target="f2">Withdraw</a>&nbsp&nbsp
 	<a href="depositblock/<c:out value='${cid}'/>" target="f2">Deposit</a>&nbsp&nbsp
 	<a href="/capstone/view/<c:out value='${cid}'/>" target="f2">View Transactions</a>&nbsp&nbsp
 	<a href="transferblock/<c:out value='${cid}'/>" target="f2">Transfer</a>&nbsp&nbsp
 	<a href="request/<c:out value='${cid}'/>" target="f2">Request Cheque book</a>
 	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 	<a href="notify/<c:out value='${cid}'/>" target="f2">Notifications</a>&nbsp&nbsp
 	<a href="bankhome.jsp">Logout</a>
</b>
</div>
<iframe name="f2" src="customerheader.jsp" width=1342px height=515px frameborder="1" 
style="border:0px solid black" allowfullscreen></iframe>
<div class="footer">
<center style="font-family: times, serif;  font-style:italic">@Copyright 2021 |ICIN BANK| All rights reserved
</center>
</div>
</body>
</html>