<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>*사용자 삭제</title>
</head>
<body>
		<center>
			<h1>
				<span style="color: red;">※사용자 삭제 실패※</span>
			</h1>
			<h2>
				전화번호가 등록되어있는 사용자입니다.<br> 사용자에게 등록된 전화번호를 모두 삭제하십시오.
			</h2>
		</center>
		<table width=550 align=center>
			<tr>
				<td width=450></td>
				<td align=right><input type=button value="목록"
					OnClick="location.href='list'"></td>
				<td align=right><input type=button value="사용자 정보"
					OnClick="location.href='view?key=${userDelete.id}'"></td>
			</tr>
		</table>
</body>
</html>
