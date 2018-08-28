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

<title>*search_result</title>
<style type="text/css">
a {
	text-decoration: none
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<c:if test="${type eq 'user'}">
		<h1>
			<center>사용자 정보 조회 완료</center>
		</h1>
		<c:choose>
			<c:when test="${fn:length(userList) == 0}">
				<h2>
					<center>
						이름 [<span style="color: red;">${searching_user}</span>]와 이름이 일치하는 사용자가 없습니다.
					</center>
				</h2>
				<br>
				<table align=center>
					<tr>
						<td>
							<button class="small ui blue button" OnClick="location.href='list'">목록</button>
						</td>
						<td>
							<button class="small ui violet button" OnClick="location.href='insert_user'">사용자 등록</button> 
							<input type=hidden name=error value=insert_user>
						</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<center>
					<h2>
						이름 [<span style="color: red;">${searching_user}</span>] 사용자 정보가 조회되었습니다.
					</h2>
					<br>
					<div style='width: 800px;'>
						<table class="ui large celled table">
							<thead>
								<tr class="center aligned">
									<th><b>No.</b></th>
									<th><b>user_id</b></th>
									<th><b>이름</b></th>
									<th><b>나이</b></th>
									<th><b>성별</b></th>
									<th><b>주소</b></th>
								</tr>
							</thead>
							<c:forEach items="${userList}" var="userList" varStatus="status">
								<tr class="center aligned">
									<td>${status.count}</td>
									<td>${userList.id}</td>
									<td><a href="view?key=${userList.id}">${userList.name}</a></td>
									<td>${userList.age}</td>
									<td>
										<c:if test="${userList.gender eq 'M'}">남자</c:if> 
										<c:if test="${userList.gender eq 'W'}">여자</c:if>
									</td>
									<td>${userList.address}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<table width=800 align=center>
						<tr>
							<td align=right>
								<button class="small ui blue button" OnClick="location.href='list'">목록</button>
							</td>
						</tr>
					</table>
				</center>
			</c:otherwise>
		</c:choose>
	</c:if>


	<c:if test="${type eq 'phone'}">
		<center>
			<h1>전화번호 정보 조회 완료</h1>
			<c:choose>
				<c:when test="${phone.id == null}">
					<h2>
						[<span style="color: red;">${searching_phone}</span>]와 일치하는 전화번호가 없습니다.
					</h2>
					<br>
					<table align=center>
						<tr>
							<td>
								<button class="small ui blue button" OnClick="location.href='list'">목록</button>
							</td>
							<td>
								<button class="small ui teal button" OnClick="location.href='new_phone'">전화번호 등록</button> 
							</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<h2>
						전화번호 [<span style="color: red;">${phone.number}</span>] 정보가 조회되었습니다.
					</h2>
					<br>
					<div style='width: 800px;'>
						<table class="ui large celled table">
							<thead>
								<tr class="center aligned">
									<th><b>phone_id</b></th>
									<th><b>전화번호</b></th>
									<th><b>통신사</b></th>
									<th><b>user_id</b></th>
									<th><b>사용자이름</b></th>
								</tr>
							</thead>
							<tr class="center aligned">
								<td>${phone.id}</td>
								<td>${phone.number}</td>
								<td>${phone.telecom_company}</td>
								<td>${phone.user.id}</td>
								<td><a href="view?key=${phone.user.id}">${phone.user.name}</a></td>
							</tr>
							</tbody>
						</table>
					</div>
					<table width=800 align=center>
						<tr>
							<td align=right>
								<button class="small ui blue button"
									OnClick="location.href='list'">목록</button>
							</td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
		</center>
	</c:if>
</body>
</html>
