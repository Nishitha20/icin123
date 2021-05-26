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
.button 
{
    display: block;
    width: 200px;
    height: 25px;
    background: #4E9CAF;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    line-height: 25px;
    text-decoration:none;
    font-size:20px;
}
</style>
</head>
<body>
<center>
<h1>${msg }</h1>
<a class="button" href="transfer1/${cid }" target="f2">Add New Recipients</a>

</center>
</body>
</html>