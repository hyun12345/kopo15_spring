<!--k15전아현 / 2018.09.06.-->
<%@ page contentType="text/html;charset=UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<title>쿠키 값 검사</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie thisCookie = cookies[i];
			if ("name".equals(thisCookie.getName())) {
				thisCookie.setMaxAge(0); //유효기간 0으로 설정 -> 지워짐
				response.addCookie(thisCookie); // 쿠키를 세팅
			}
		}
	%>
<center><h1>JSP 쿠키 삭제 TEST</h1></center>
</body>
</html>