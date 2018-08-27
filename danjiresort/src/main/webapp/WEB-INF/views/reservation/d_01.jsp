<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- <!DOCTYPE html> -->
<html>
<head>
	<title>*예약상황</title>
</head>

<body BACKGROUND="/danjiresort/resources/backgroundimg2.jpg">
<%@include file="top.jsp" %>

<center>
<table border=0 align=center>
	<tr>
		<td colspan=4>
		<h2>예약상황</h2>
		</td>
	</tr>
	<table cellspacing=1 cellpadding=5 width=600 border=1 align=center style="background-color : white;">
		<tbody align=center>
			<tr style="background-color : #dbd5d9;">
				<td width=150><b>예약일</b></td>
				<td width=150><b>스위트룸</b></td>
				<td width=150><b>더블룸</b></td>
				<td width=150><b>싱글룸</b></td>
			</tr>
		<c:forEach items="${reservations}" var="reservations">
			<tr>
				<td width=150>
				<c:choose>
					<c:when test="${(reservations.day eq '(토)') || (reservations.day eq '(일)')}">
					<span style="color:red">${reservations.date}&nbsp;${reservations.day}</span>
					</c:when>
					<c:otherwise>
					${reservations.date}&nbsp;${reservations.day}
					</c:otherwise>
				</c:choose>
				<input type=hidden name=date value="${reservations.date}" size=70 maxlength=70 required>
				</td>
				<td width=150>
				<a href="reservation_form">
				${reservations.reservation1}
				</a></td>
				<td width=150>
				<a href="reservation_form">
				${reservations.reservation2}
				</a></td>
				<td width=150>
				<a href="reservation_form">
				${reservations.reservation3}
				</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</table>
</center>
</body>
</html>
