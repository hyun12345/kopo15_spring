<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>*공지리스트</title>
<style type="text/css">
	a { text-decoration:none }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	function requestXml(id) {
		$.ajax({
			type : "GET",
			url : "api/gongji/one/xml/" + id,
			async : false,
			contentType : "application/xml; charset=utf-8",
			success : function(xml) {
				console.log(xml);
			}
		});
	}
	
	function requestJson(id) {
		$.ajax({
			type : "GET",
			url : "api/gongji/one/json/" + id,
			async : false,
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				console.log(json);
			}
		});
	}	
</script>
</head>
<body>
<h2><center>공지리스트</center></h2>

<table width=650 align=center>
	<tr>
		<td align=left>page : ${page}</td>
	</tr>
	<tr>
		<td align=left>itemSizePerPage : ${itemSizePerPage}</td>
	</tr>
	<tr>
		<td align=left>total_page : ${paginationVO.total_page}</td>
	</tr>
</table>

<table cellspacing=1 cellpadding=5 width=650 border=1 align=center>
	<tbody align=center>
		<tr>
			<td width=75><b>번호</b></td>
			<td width=325><b>제목</b></td>
			<td width=100><b>등록일</b></td>
			<td width=75><b>작성자</b></td>
			<td width=75><b>조회수</b></td>
		</tr>
		<c:forEach items="${gongjiList}" var="gongjiList">
		<tr>
			<td width=75>${gongjiList.id}</td>
			<td width=325 align=left>
			<a href="gongji_view?key=${gongjiList.id}">
			<c:if test="${gongjiList.relevel > 0}">
						<c:forEach begin="1" end="${gongjiList.relevel}">
            			[Re]
            			</c:forEach>
			</c:if>
			${gongjiList.title}
			<c:if test="${gongjiList.isNewGongji() }">
       			<blink>(<span style="color:red">New</span>)</blink>
  			</c:if>
			</a></td>
			<td width=100><fmt:formatDate value="${gongjiList.date}" pattern="yyyy-MM-dd" /></td>
			<td width=75>${gongjiList.user.name}</td>
			<td width=75>${gongjiList.viewcnt}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<table width=650 align=center>
	<tr>
		<td colspan=2 align=center>
		<c:url value="/gongji_list?page=${paginationVO.first}&itemSizePerPage=${itemSizePerPage}" var="url"/>
			<a href="${url}">&#171;&nbsp;</a>
		<c:url value="/gongji_list?page=${paginationVO.prev}&itemSizePerPage=${itemSizePerPage}" var="url"/>
			<a href="${url}">&lt;&nbsp;</a>
		<c:forEach var="i" begin="${paginationVO.start}" end="${paginationVO.end}" step="1">
     	&thinsp;
       	<c:url value="/gongji_list?page=${i}&itemSizePerPage=${itemSizePerPage}" var="url"/>
       		<STRONG><a href="${url}">${i}</a></STRONG>
     	&thinsp;
     	</c:forEach>
    	<c:url value="/gongji_list?page=${paginationVO.next}&itemSizePerPage=${itemSizePerPage}" var="url"/>
			<a href="${url}">&nbsp;&gt;</a>
		<c:url value="/gongji_list?page=${paginationVO.last}&itemSizePerPage=${itemSizePerPage}" var="url"/>
			<a href="${url}">&nbsp;&#187;</a>
		</td>
	</tr>
	<tr>
		<td align=left>
			<button onclick="requestXml(392)">requestXml</button>
			<button onclick="requestJson(392)">requestJsons</button>
		</td>
		<td align=right>
			<input type=submit value="신규" OnClick="location.href='gongji_insert'">
		</td>
	</tr>
</table>
</body>
</html>
