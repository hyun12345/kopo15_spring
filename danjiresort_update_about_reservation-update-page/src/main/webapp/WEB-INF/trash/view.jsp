<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>*게시글확인</title>
</head>
<body>
<h2><center>게시글확인</center></h2>

<table cellspacing=1 cellpadding=5 width=550 border=1 align=center>
		<tr>
			<td width=100 align=center><b>번호</b></td>
			<td colspan=3>${gongjiView.id}</td>
		</tr>
		<tr>
			<td width=100 align=center><b>작성자</b></td>
			<td colspan=3>${gongjiView.user.name}
			<input type=hidden size=70 maxlength=70 placeholder="ID를 입력하십시오." required>
			</td>
		</tr>
    	<tr>
			<td width=100 align=center><b>제목</b></td>
			<td colspan=3>${gongjiView.title}</td>
		</tr>
		<tr>
			<td width=100 align=center><b>일자</b></td>
			<td colspan=3><fmt:formatDate value="${gongjiView.date}" pattern="yyyy-MM-dd" /></td>
		</tr>
		<tr>
			<td width=100 align=center><b>조회수</b></td>
			<td colspan=3>${gongjiView.viewcnt}</td>
		</tr>
		<tr>
			<td width=100 align=center><b>내용</b></td>
			<td colspan=3>
<!-- 			<textarea style="width:450px; height:250px; border:0; background-color:transparent; filter:chroma(color=ffffff);" name=content cols=70 row=600 readonly> -->
			<div id=content style="width:450px; height:250px;">${gongjiView.content}</div>
			<!--폰트 크기 등과 같은 가시성의 이유로 div 태그 사용 / style 태그 활용하여 출력 표의 넓이&높이 설정 가능-->
<!-- 			</textarea> -->
			</td>
		</tr>
		<c:if test="${gongjiView.relevel > 0}">
		<tr>
			<td width=100 align=center><b>원글</b></td>
			<td>${gongjiView.rootid.id}</td>
<!-- 			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
<!--     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
    		<td width=100><b>부모글</b></td>
    		<td>${gongjiView.parent.id}</td>
	    </tr>
	    <tr>
			<td width=100><b>댓글수준</b></td>
			<td>${gongjiView.relevel}</td>
<!--     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
<!--     		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
    		<td width=100><b>댓글내 순서</b></td>
    		<td>${gongjiView.recnt}</td>
    	</tr>
    	</c:if>
</table>

<table width=550 align=center>
<tr>
<td width=500></td>
<td align=right><input type=button value="목록" OnClick="location.href='gongji_list'"></td>
<td align=right><input type=button value="수정" OnClick="location.href='gongji_update?key=${gongjiView.id}'"></td>
<td align=right><input type=button value="삭제" OnClick="location.href='gongji_delete?key=${gongjiView.id}'"></td>
<td align=right><input type=button value="댓글" OnClick="location.href='gongji_reinsert?key=${gongjiView.id}'"></td>
</tr>
</table>
</body>
</html>
