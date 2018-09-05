<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>*예약 완료</title>
	
	<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>
	
	<style>
        body {
            /* The image used */
            background-image: url("resources/backgroundimg2.jpg");
    
            /* Full height */
            height: 100%;
    
            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
   </style>
	
</head>

<body>
<%@include file="top.jsp" %>
<br><br><br>
<center>
<strong><h1><span style="color:red;">${reservation.user.name}</span>님</h1></strong>
<strong><h2><span style="color:red;">${date}&nbsp;&nbsp;${reservation.room.type}</span> 방이 예약되었습니다.</h2></strong>
</center>
<br><br>
<table width=550 align=center>
<tr>
<td align=right><button class="small ui olive button" OnClick="location.href='reservation_list'">예약상황</button></td>
</tr>
</table>
</body>
</html>
