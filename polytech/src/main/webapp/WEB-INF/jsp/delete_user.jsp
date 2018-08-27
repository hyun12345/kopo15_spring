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
			<h1>
				<center>사용자 삭제 완료</center>
			</h1>
			<strong><h2>
					<center>
						[id : <span style="color: red;">${userDelete.id}</span>] 사용자가 삭제되었습니다.
					</center>
				</h2></strong>
	<table width=550 align=center>
		<tr>
			<td align=right><input type=button value="목록"
				OnClick="location.href='list'"></td>
		</tr>
	</table>
</body>
</html>
