<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>*게시글/댓글 수정 완료</title>
</head>
<body>
<h1><center>게시글/댓글 수정 완료</center></h1>
<strong><h2><center>${gongjiUpdate.id}번 글이 수정되었습니다.</center></h2></strong>
<table width=550 align=center>
<tr>
<td align=right><input type=button value="목록으로" OnClick="location.href='gongji_list'"></td>
</tr>
</table>
</body>
</html>
