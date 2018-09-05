<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- <!DOCTYPE html> -->
<html>
<head>
<title>*예약</title>

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

select {
	width: 200px;
}
</style>

</head>

<body>
	<%@include file="top.jsp"%>
	<form action="reservation_result">
		<center>
		<br><br><br>
			<table border=0 align=center>
				<tr>
					<td colspan=4>
						<h2>예약</h2> <br>
						<input type=hidden name=type value=duplicate>
					</td>
				</tr>
				<table cellspacing=1 cellpadding=5 border=1 align=center style="background-color: white;">
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>성명</b></td>
						<td>
							<!-- 					<select name="user_id"> --> <%-- 								<option value="${room.id}">${room.type}</option> --%>
							<%-- 							<c:forEach items="${userList}" var="userList"> --%> <%-- 								<option value="${userList.id}">${userList.name}</option> --%>
							<%-- 							</c:forEach> --%> <!-- 					</select></td>  -->
							${user.name}<input type=hidden name=user_id value="${user.id}">
						</td>
						<!-- 			<input type=hidden name=key value="INSERT" readonly></td> -->
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>예약일자</b></td>
						<td>${date}<input type=hidden name=date value="${date}">
						</td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>예약방</b></td>
						<td><select name="room_id">
<%-- 								<option value="${room.id}">${room.type}</option> --%>
								<c:forEach items="${roomList}" var="roomList">
									<option value="${roomList.id}" <c:if test="${roomList.id eq room_id}">selected="selected"</c:if>> ${roomList.type}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>주소</b></td>
						<td>${user.addr}</td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>전화번호</b></td>
						<td>${user.telnum}</td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>남기실말</b></td>
						<td><input type=text name=comment size=70 maxlength=70
							placeholder="남기실말을 입력하십시오." title="ex)전망 좋은 방으로 해주세요."></td>
					</tr>
				</table>

				<table>
					<tr>
						<td><br>
							<input type=button class="small ui olive button" OnClick="location.href='reservation_list'" value="예약상황">
<!-- 							<button class="small ui olive button" OnClick="location.href='reservation_list'">예약목록</button> -->
<!-- button 태그시 form에 적용되어 '예약목록' 버튼 클릭하더라도 예약이 되는 오류가 발생 -->
							<button class="small ui olive button" OnClick="submit()">전송</button></td>
					</tr>
				</table>
			</table>
	</form>
	</center>
</body>
</html>
