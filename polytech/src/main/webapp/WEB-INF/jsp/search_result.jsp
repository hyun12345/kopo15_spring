<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>*search_result</title>
<style type="text/css">
a {
	text-decoration: none
}
</style>
</head>
<body>
	<c:if test="${type eq 'user'}">
		<h1>
			<center>사용자 정보 조회 완료</center>
		</h1>
		<c:choose>
			<c:when test="${fn:length(userList) == 0}">
				<h2>
					<center>이름 [<span style="color: red;">${searching_user}</span>]와 이름이 일치하는 사용자가 없습니다.</center>
				</h2>
				<table width=500 align=center>
					<tr>
						<td width=420></td>
						<td><input type=button value="목록"
							OnClick="location.href='list'"></td>
						<td><input type=button value="사용자 등록"
							OnClick="location.href='insert_user'">
							<input type=hidden name=error value=insert_user></td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<h2>
					<center>
						이름 [<span style="color: red;">${searching_user}</span>] 사용자 정보가 조회되었습니다.
					</center>
				</h2>
				<table cellspacing=1 cellpadding=5 width=900 border=1 align=center>
					<tbody align=center>
						<tr>
							<td width=100><b>No.</b></td>
							<td width=100><b>user_id</b></td>
							<td width=150><b>이름</b></td>
							<td width=100><b>나이</b></td>
							<td width=100><b>성별</b></td>
							<td width=350><b>주소</b></td>
						</tr>
						<c:forEach items="${userList}" var="userList" varStatus="status">
							<tr>
								<td width=100>${status.count}</td>
								<td width=100>${userList.id}</td>
								<td width=150><a href="view?key=${userList.id}">${userList.name}</a></td>
								<td width=100>${userList.age}</td>
								<td>
								<c:if test="${userList.gender eq 'M'}">남자</c:if>
								<c:if test="${userList.gender eq 'W'}">여자</c:if>
								</td>
								<td width=350>${userList.address}</td>
								<%-- <td width=200>${userList.phone.number}</td> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<table width=900 align=center>
					<tr>
						<td align=right><input type=button value="목록"
							OnClick="location.href='list'"></td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</c:if>


	<c:if test="${type eq 'phone'}">
		<h1>
			<center>전화번호 정보 조회 완료</center>
		</h1>
		<c:choose>
			<c:when test="${phoneList.id == null}">
				<h2>
					<center>번호 [<span style="color: red;">${searching_phone}</span>]와 일치하는 전화번호가 없습니다.</center>
					<input type=hidden name=searching_phone value="${searching_phone}">
				</h2>
				<table width=500 align=center>
					<tr>
						<td width=420></td>
						<td><input type=button value="목록"
							OnClick="location.href='list'"></td>
						<td><input type=button value="전화번호 등록"
							OnClick="location.href='new_phone'"></td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<h2>
					<center>
						전화번호 [<span style="color: red;">${phone.number}</span>] 정보가 조회되었습니다.
					</center>
				</h2>
				<table cellspacing=1 cellpadding=5 width=600 border=1 align=center>
					<tbody align=center>
						<tr>
							<td width=100><b>phone_id</b></td>
							<td width=200><b>전화번호</b></td>
							<td width=200><b>통신사</b></td>
							<td width=100><b>user_id</b></td>
							<td width=200><b>사용자이름</b></td>
						</tr>
<%-- 						<c:forEach items="${phone}" var="phoneList"> --%>
							<tr>
								<td width=100>${phone.id}</td>
								<td width=200>${phone.number}</td>
								<td width=200>${phone.telecom_company}</td>
								<td width=100>${phone.user.id}</td>
								<td width=200><a href="view?key=${phone.user.id}">${phone.user.name}</a></td>
							</tr>
<%-- 						</c:forEach> --%>
					</tbody>
				</table>
				<table width=600 align=center>
					<tr>
						<td align=right><input type=button value="목록"
							OnClick="location.href='list'"></td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>
