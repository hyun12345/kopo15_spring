<!--k15전아현 / 2018.09.06.-->
<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<%@ page import="java.text.*, java.util.*" %>
<%
session.setAttribute("session_id", "DANJI");
SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd [hh:mm:ss]");
long createTime = (long) session.getCreationTime(); //세션 생성 시간
long lastTime = (long) session.getLastAccessedTime(); //마지막 처리 시간
%>
<head>
<title>세션 테스트</title>
</head>
<body>
<center><table border=0>
<tr><td>
<b>session 생성 시간</b> <span style="color:red;">==></span> <%= fmt.format(new Date(createTime)) %> <br>
</td></tr>
<tr><td>
<b>session 마지막 처리 시간</b> <span style="color:red;">==></span> <%= fmt.format(new Date(lastTime)) %> <br>
</td></tr>
<tr><td>
<b>session 유지 시간</b> <span style="color:red;">==></span> <%= (int) session.getMaxInactiveInterval() %> <br>
</td></tr>
<tr><td>
<b>session 유지 시간 변경</b> <span style="color:red;">==></span> <% session.setMaxInactiveInterval(5); %> <br>
</td></tr>
<tr><td>
<b>session 값 표시</b> <span style="color:red;">==></span> <%= (String) session.getAttribute("session_id") %> <br>
</td></tr>
<tr><td>
<b>session ID</b> <span style="color:red;">==></span> <%= session.getId() %> <br>
</td></tr>
<tr><td>
<b>session 유지 시간</b> <span style="color:red;">==></span> <%= (int) session.getMaxInactiveInterval() %> <br>
</td></tr>
</table></center>
</body>
</html>