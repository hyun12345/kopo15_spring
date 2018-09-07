<!--k15전아현 / 2018.09.06.-->
<%@ page contentType="text/html;charset=UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<title>쿠키 값 검사</title>
</head>
<body BACKGROUND="/danjiresort/resources/backgroundimg2.jpg">
<center><h1>JSP 쿠키 사용 TEST<br></h1></center>
	<%
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie thisCookie = cookies[i];
			if ("name".equals(thisCookie.getName())) {
				out.println("<center><h2><span style=\"color:yellowgreen;\">이름 : " + thisCookie.getValue() + "<br></span></h2></center>");
			}
		}
	%>
</body>
</html>