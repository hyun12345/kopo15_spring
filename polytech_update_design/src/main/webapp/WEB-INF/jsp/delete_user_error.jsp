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
		<center>
			<h1>
				<span style="color: red;">※사용자 삭제 실패※</span>
			</h1>
			<h2>
				전화번호가 등록되어있는 사용자입니다.<br> 사용자에게 등록된 전화번호를 모두 삭제하십시오.
			</h2>
		</center>
		<br>
		<table align=center>
			<tr>
				<td align=right>
					<button class="small ui blue button" OnClick="location.href='list'">목록</button></td>
				<td align=right>
					<button class="small ui violet button" OnClick="location.href='view?key=${userDelete.id}'">사용자 정보</button></td>
			</tr>
		</table>
</body>
</html>
