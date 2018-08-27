<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>*insert completed</title>
</head>
<body>
<c:if test="${type eq 'insert_user'}">
<h1><center>신규 사용자 등록 완료</center></h1>
</c:if>
<c:if test="${type eq 'insert_phone'}">
<h1><center>신규 전화번호 등록 완료</center></h1>
</c:if>
<c:if test="${type eq 'new_phone'}">
<h1><center>신규 전화번호 등록 완료</center></h1>
</c:if>
<table width=550 align=center>
<tr>
<td width=450></td>
<td align=right><input type=button value="목록" OnClick="location.href='list'"></td>
<td align=right><input type=button value="사용자 정보" OnClick="location.href='view?key=${user.id}'"></td>
</tr>
</table>
</body>
</html>
