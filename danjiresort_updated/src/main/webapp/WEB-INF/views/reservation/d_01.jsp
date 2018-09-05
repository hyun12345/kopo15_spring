<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- <!DOCTYPE html> -->
<html>
<head>
<title>*예약상황</title>

<style>
        body {
            /* The image used */
            background-image: url("resources/backgroundimg2.jpg");
    
            /* Full height */
            height: 100%;
    
            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
   </style>

</head>

<body>
<!-- <div style="background-image: url('resources/backgroundimg2.jpg'); background-size: cover; height: 100%;"> -->
	<%@include file="top.jsp"%>

	<center>
		<table border=0 align=center>
			<tr>
				<td colspan=4>
					<h2>예약상황</h2>
				</td>
			</tr>
			<tr><td>
			<table cellspacing=1 cellpadding=5 width=650 border=1 align=center style="background-color: white;">
				<tbody align=center>
					<tr style="background-color: #dbd5d9;">
						<td width=50><b>index</b></td>
						<td width=150><b>예약일</b></td>
						<td width=150><b>스위트룸</b></td>
						<td width=150><b>더블룸</b></td>
						<td width=150><b>싱글룸</b></td>
					</tr>
					<c:forEach items="${reservations}" var="reservations" varStatus="status">
					<input type=hidden name=date value="${reservations.date}">
						<tr>
							<td width=50>
								${status.count}
							</td>
							<td width=150>
								<c:choose>
									<c:when test="${(reservations.day eq '(토)') || (reservations.day eq '(일)')}">
										<span style="color: red">${reservations.date}&nbsp;${reservations.day}</span>
									</c:when>
									<c:otherwise>
										${reservations.date}&nbsp;${reservations.day}
									</c:otherwise>
								</c:choose>
							</td>
							<td width=150>
								<c:choose>
									<c:when test="${reservations.suitroom == '예약가능'}">
										<a href="reservation_form?date=${reservations.date}&room=1">
										${reservations.suitroom}
										</a>
									</c:when>
									<c:otherwise>
										<strong><span style="color:yellowgreen;">${reservations.suitroom}</span></strong>
									</c:otherwise>
								</c:choose>
							</td>
							<td width=150>
								<c:choose>
									<c:when test="${reservations.doubleroom == '예약가능'}">
										<a href="reservation_form?date=${reservations.date}&room=2">
										${reservations.doubleroom}
										</a>
									</c:when>
									<c:otherwise>
										<strong><span style="color:yellowgreen;">${reservations.doubleroom}</span></strong>
									</c:otherwise>
								</c:choose>
							</td>
							<td width=150>
								<c:choose>
									<c:when test="${reservations.singleroom == '예약가능'}">
										<a href="reservation_form?date=${reservations.date}&room=3">
										${reservations.singleroom}
										</a>
									</c:when>
									<c:otherwise>
										<strong><span style="color:yellowgreen;">${reservations.singleroom}</span></strong>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table></td></tr>
		</table>
	</center>
<!-- 	</div> -->
</body>
</html>
