<!--k15전아현 / 2018.09.06.-->
<%@ page contentType="text/html;charset=UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<%
	String myName = "DANJI.LOVE";
	Cookie cookieName = new Cookie("name", myName);
	cookieName.setMaxAge(-1); //브라우저 켜져 있을 때 까지
	response.addCookie(cookieName); // reponse 객체에 보내야 사용 가능
%>

<html>
<head>
<title>쿠키 저장</title>
</head>
<body BACKGROUND="/danjiresort/resources/backgroundimg2.jpg">
<center><h1>JSP 쿠키 사용 TEST</h1></center>
</body>

</html>