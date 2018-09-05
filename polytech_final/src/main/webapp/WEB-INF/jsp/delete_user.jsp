<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>

<title>*사용자 삭제</title>
</head>
<body>
<br><br><br>
	<h1>
		<center>사용자 삭제 완료</center>
	</h1>
	<br>
	<strong><h2>
			<center>
				[id : <span style="color: red;">${userDelete.id}</span>] 사용자가 삭제되었습니다.
			</center>
		</h2></strong>
		<br>
	<table align=center>
		<tr>
			<td align=right><button class="small ui blue button" OnClick="location.href='list'">목록</button></td>
		</tr>
	</table>
</body>
</html>
