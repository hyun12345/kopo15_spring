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

<title>*사용자 정보 조회</title>
</head>
<body>
<br><br><br>
	<center>
		<h1>
			[id : <span style="color: red;">${userView.id}</span>] 사용자 정보 수정
		</h1>
		<br>
		<div style='width: 400px;'>
			<table align=center border=0>
				<div style='width: 400px;'>
					<table class="ui large definition table">
						<tr class="center aligned">
							<td width=100 align=center><b>이름</b></td>
							<td colspan=3>${userView.name}</td>
						</tr>
						<tr class="center aligned">
							<td width=100 align=center><b>등록일</b></td>
							<td colspan=3>${userView.enrolldate}</td>
						</tr>
						<tr class="center aligned">
							<td width=100 align=center><b>나이</b></td>
							<td colspan=3>${userView.age}</td>
						</tr>
						<tr class="center aligned">
							<td width=100 align=center><b>성별</b></td>
							<td colspan=3>
								<c:if test="${userView.gender eq 'M'}">남자</c:if> 
								<c:if test="${userView.gender eq 'W'}">여자</c:if>
							</td>
						</tr>
						<tr class="center aligned">
							<td width=100 align=center><b>주소</b></td>
							<td colspan=3>${userView.address}</td>
						</tr>
					</table>

					<table border=0 align=center>
						<tr>
							<td align=center>
								<button class="small ui violet button" OnClick="location.href='update_user?key=${userView.id}'">사용자 수정</button>
							</td>
							<td align=center>
								<input type=hidden name=error value=delete_user>
								<button class="small ui violet button" OnClick="location.href='delete_user?key=${userView.id}'">사용자 삭제</button>
							</td>
						</tr>
					</table>
				</div>
				<br>
				<br>
				<br>
				<br>
				<c:choose>
					<c:when test="${fn:length(phoneView) == 0}">
						<h2>
							<center>등록된 전화번호가 없습니다.</center>
						</h2>
						<table border=0 align=center>
							<tr>
								<td align=center>
									<button class="small ui blue button" OnClick="location.href='list'">목록</button>
								</td>
								<td align=center>
									<button class="small ui teal button" OnClick="location.href='insert_phone?key=${userView.id}'">전화번호 추가</button>
								</td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<center>
							<h2>등록된 전화번호 정보</h2>
							<br>
						</center>
						<div style='width: 800px;'>
							<table class="ui large celled table">
								<thead>
									<tr class="center aligned">
										<th><b>No.</b></th>
										<th><b>phone_id</b></th>
										<th><b>전화번호</b></th>
										<th><b>통신사</b></th>
										<th><b>등록일</b></th>
										<th><b>기타</b></th>
									</tr>
								</thead>
								<c:forEach items="${phoneView}" var="phoneView" varStatus="status">
									<tr class="center aligned">
										<td>${status.count}</td>
										<td>${phoneView.id}</td>
										<td>${phoneView.number}</td>
										<td>${phoneView.telecom_company}</td>
										<td>${phoneView.enrolldate}</td>
										<td colspan=2>
											<button class="mini ui teal button" OnClick="location.href='update_phone?key=${phoneView.id}'">수정</button>
											<button class="mini ui teal button" OnClick="location.href='delete_phone?key=${phoneView.id}'">삭제</button>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<br>
						<table border=0 align=center>
							<tr>
								<td width=600></td>
								<td align=right>
									<button class="small ui blue button" OnClick="location.href='list'">목록</button>
								</td>
								<td align=right>
									<button class="small ui teal button" OnClick="location.href='insert_phone?key=${userView.id}'">전화번호 추가</button>
								</td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
				<br>
			</table>
		</div>
		<br>
	</center>
</body>
</html>