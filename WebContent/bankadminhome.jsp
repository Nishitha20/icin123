<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank ADmin Home</title>
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
 	<a href="block" target="f2">Authorize User</a>&nbsp&nbsp
 	<a href="wblock" target="f2">Withdraw Permissions</a>&nbsp&nbsp
 	<a href="dblock" target="f2">Deposit Permissions</a>&nbsp&nbsp
 	<a href="tblock" target="f2">Transfer Permissions</a>&nbsp&nbsp
 	<a href="cheque" target="f2">Cheque Book requests</a>&nbsp&nbsp
 	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 	<a href="bankadmin.jsp">Logout</a>
</b>
</div>
<iframe name="f2" src="customerheader.jsp" width=1342px height=515px frameborder="1" 
style="border:0px solid black" allowfullscreen></iframe>
<div class="footer">
<center style="font-family: times, serif;  font-style:italic">@Copyright 2021 |ICIN BANK| All rights reserved
</center>
</div>
</body>
</body>
</html>