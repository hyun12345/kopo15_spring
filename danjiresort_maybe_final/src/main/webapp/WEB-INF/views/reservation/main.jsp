<!--k15전아현 / 2018.08.01.-->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session = "true" %>

<html>

<head>
<title>Welcome</title>

<link rel="stylesheet" type="text/css"
href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>

</head>

<body>
	<center>
		<%@include file="top.jsp"%>
		<br> <br> <br> <br> <img src="/danjiresort/resources/resort1.jpg" width=750 height=500>
		<br><br>
		<h1><i><span style="color:#1c4c87; font-family:Merienda;">Thank you for visiting Danji Resort</span></i></h1>
		<h2><span style="color:#92B3B7; font-family: 새굴림;">최근 방문일 : ${timeCookie}</span></h2>
	</center>
</body>

</html>