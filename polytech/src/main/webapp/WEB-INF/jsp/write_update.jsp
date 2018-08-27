<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>*update completed</title>
</head>
<body>
<c:if test="${type eq 'update_user'}">
<h1><center>사용자 정보 수정 완료</center></h1>
<h2><center>[id : <span style="color:red;">${key}</span>] 사용자 정보가 수정되었습니다.</center></h2>
</c:if>
<c:if test="${type eq 'update_phone'}">
<h1><center>전화번호 정보 수정 완료</center></h1>
<h2><center>[<span style="color:red;">${key}</span>]번 전화번호 정보가 수정되었습니다.</center></h2>
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
