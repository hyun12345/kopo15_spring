<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>*사용자 정보 조회</title>
</head>
<body>
	<table border=0 align=center>
		<tr>
			<td>
				<center>
					<h2>
						[id : <span style="color: red;">${userView.id}</span>] 사용자 정보 조회
					</h2>
				</center>
			</td>
		</tr>
		<tr>
			<table cellspacing=1 cellpadding=5 width=550 border=1 align=center>
				<tr>
					<td width=100 align=center><b>이름</b></td>
					<td colspan=3>${userView.name}</td>
				</tr>
				<tr>
					<td width=100 align=center><b>등록일</b></td>
					<td colspan=3>${userView.enrolldate}</td>
				</tr>
				<tr>
					<td width=100 align=center><b>나이</b></td>
					<td colspan=3>${userView.age}</td>
				</tr>
				<tr>
					<td width=100 align=center><b>성별</b></td>
					<td colspan=3><c:if test="${userView.gender eq 'M'}">
					남자
					</c:if> <c:if test="${userView.gender eq 'W'}">
					여자
					</c:if></td>
				</tr>
				<tr>
					<td width=100 align=center><b>주소</b></td>
					<td colspan=3>${userView.address}</td>
				</tr>
			</table>
			<table border=0 align=center>
				<tr>
					<td align=center><input type=button value="사용자 수정"
						OnClick="location.href='update_user?key=${userView.id}'"></td>
					<td align=center><input type=button value="사용자 삭제"
						OnClick="location.href='delete_user?key=${userView.id}'">
						<input type=hidden name=error value=delete_user></td>
				</tr>
			</table>
			<br>
			<br>
			<c:choose>
				<c:when test="${fn:length(phoneView) == 0}">
					<h2>
						<center>등록된 전화번호가 없습니다.</center>
					</h2>
					<table border=0 align=center>
						<tr>
							<td align=center><input type=button value="목록"
								OnClick="location.href='list'"></td>
							<td align=center><input type=button value="전화번호 등록"
								OnClick="location.href='insert_phone?key=${userView.id}'"></td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
				<center>
					<h2>
						등록된 전화번호 정보
					</h2>
				</center>
					<table cellspacing=1 cellpadding=5 width=720 border=1 align=center>
						<tr>
							<td width=50 align=center><b>No.</b></td>
							<td width=100 align=center><b>phone_id</b></td>
							<td width=150 align=center><b>전화번호</b></td>
							<td width=80 align=center><b>통신사</b></td>
							<td width=225 align=center><b>등록일</b></td>
							<td width=115 align=center><b>기타</b></td>
						</tr>
						<c:forEach items="${phoneView}" var="phoneView" varStatus="status">
							<tr>
								<td align=center>${status.count}</td>
								<td align=center>${phoneView.id}</td>
								<td align=center>${phoneView.number}</td>
								<td align=center>${phoneView.telecom_company}</td>
								<td align=center>${phoneView.enrolldate}</td>
								<td align=center colspan=2><input type=button value="수정"
									OnClick="location.href='update_phone?key=${phoneView.id}'">
								<input type=button value="삭제"
									OnClick="location.href='delete_phone?key=${phoneView.id}'"></td>
							</tr>
							<!-- 							<tr> -->
							<!-- 								<td width=100 align=center><b>phone_index</b></td> -->
							<%-- 								<td colspan=3>${phoneView.id}</td> --%>
							<!-- 							</tr> -->
						</c:forEach>
					</table>
					<br>
					<table border=0 align=center>
						<tr>
							<td width=530></td>
							<td align=right><input type=button value="목록"
								OnClick="location.href='list'"></td>
							<td align=right><input type=button value="전화번호 추가 등록"
								OnClick="location.href='insert_phone?key=${userView.id}'"></td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
			<br>
		</tr>
	</table>
	<br>

</body>
</html>