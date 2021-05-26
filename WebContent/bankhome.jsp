<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>

<style>

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

.top
{
 	position: absolute;
  	top: 30%;
	left: 35%;
  	transform: translate(-50%, -50%);
  	color:white;
  	font-size:80px;
}

</style>
</head>

<body>
<jsp:include page="bankheader.jsp"></jsp:include>
<div class="cen">
<section>
<img src="https://www.doughroller.net/wp-content/uploads/2018/03/largest-banks-in-the-world-648x364-c-default.jpg" width=1346px height=520px>
</section>
<div class="top">ICIN Bank Management</div>
</div>
<jsp:include page="bankfooter.jsp"></jsp:include>
</body>
</html>