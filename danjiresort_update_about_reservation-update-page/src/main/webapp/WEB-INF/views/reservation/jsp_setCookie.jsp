<!--k15전아현 / 2018.09.06.-->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.text.*, java.util.*" %>
<%
	String myName = "DANJI.LOVE.TOO";
	Cookie cookieName = new Cookie("name", myName);
	cookieName.setMaxAge(-1); //브라우저 켜져 있을 때 까지
	response.addCookie(cookieName); 
	
// 	Date from = new Date();
// 	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (EE)");
// 	String date = dateformat.format(from);

// 	Cookie cookieTime = new Cookie("time", date);
// 	cookieTime.setMaxAge(-1);

// 	response.addCookie(cookieTime);// reponse 객체에 보내야 사용 가능
%>

<html>
<head>
<title>쿠키 저장</title>
</head>
<body>
<center><h1>JSP 쿠키 사용 TEST</h1></center>
</body>

</html>