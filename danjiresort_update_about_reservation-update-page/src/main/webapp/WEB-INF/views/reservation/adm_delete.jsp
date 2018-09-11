<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- <!DOCTYPE html> -->
<html>
<head>
<title>*예약취소</title>

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>

<style>

select {
	width: 200px;
}
</style>

</head>

<body>
	<%@include file="top.jsp"%>
		<center>
			<br>
			<br>
			<br>
			<h1>예약 취소</h1>
			<br>
			<h2><span style="color:#00b386;">${reservation.user.name}</span>님<br>
			<span style="color:#0095B3;"><fmt:formatDate value="${reservation.date}" pattern="yyyy-MM-dd" /></span> 일로 예약한<br>
			<span style="color:#0095B3;"> ${reservation.room.type}</span> 예약이 취소되었습니다.</h2>
			<table>
				<tr>
					<td><br> <input type=button class="small ui olive button" OnClick="location.href='adm_allview'" value="관리자페이지">
						<!-- 							<button class="small ui olive button" OnClick="location.href='reservation_list'">예약목록</button> -->
						<!-- button 태그시 form에 적용되어 '예약목록' 버튼 클릭하더라도 예약이 되는 오류가 발생 -->
				</tr>
			</table>
	</center>
</body>
</html>
