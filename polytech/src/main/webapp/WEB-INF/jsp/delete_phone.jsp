<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>*전화번호 삭제</title>
</head>
<body>
<h1><center>전화번호 삭제 완료</center></h1>
<strong><h2><center>[<span style="color:red;">${phoneDelete.id}</span>]번 전화번호가 삭제되었습니다.</center></h2></strong>
<table width=550 align=center>
<tr>
<td width=450></td>
<td align=right><input type=button value="목록" OnClick="location.href='list'"></td>
<td align=right><input type=button value="사용자 정보" OnClick="location.href='view?key=${phoneDelete.user.id}'"></td>
</tr>
</table>
</body>
</html>
