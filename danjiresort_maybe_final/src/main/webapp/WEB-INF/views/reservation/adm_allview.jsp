<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session = "true" %>

<!-- <!DOCTYPE html> -->
<html>
<head>
<title>*관리자페이지</title>

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>

</head>

<body>
	<%@include file="top.jsp"%>

	<center>
		<table border=0 align=center>
			<tr>
				<td colspan=4>
					<h2>관리자페이지</h2>
				</td>
			</tr>
			<tr>
				<td>
					<!-- 					<table class="ui pink table" cellspacing=1 cellpadding=5 width=650 border=1 align=center style="background-color: white;"> -->
					<table class="ui small pink table">
						<thead align=center>
							<tr style="background-color: #dbd5d9;">
								<th width=50 style="background-color: #dbd5d9;"><b>index</b></th>
								<th width=150 style="background-color: #dbd5d9;"><b>예약일</b></th>
								<th width=150 style="background-color: #dbd5d9;"><b>스위트룸</b></th>
								<th width=150 style="background-color: #dbd5d9;"><b>더블룸</b></th>
								<th width=150 style="background-color: #dbd5d9;"><b>싱글룸</b></th>
							</tr>
						</thead>
						<tbody align=center>
							<c:forEach items="${reservations}" var="reservations"
								varStatus="status">
								<input type=hidden name=date value="${reservations.date}">
								<tr>
									<td width=50>${status.count}</td>
									<td width=150><c:choose>
											<c:when test="${(reservations.day eq '(토)') || (reservations.day eq '(일)')}">
												<span style="color: red">${reservations.date}&nbsp;${reservations.day}</span>
											</c:when>
											<c:otherwise>
										${reservations.date}&nbsp;${reservations.day}
									</c:otherwise>
										</c:choose></td>
									<c:choose>
										<c:when test="${reservations.suitroom == '예약가능'}">
											<td width=150><span style="color:gray;">${reservations.suitroom}</span></td>
										</c:when>
										<c:otherwise>
											<td width=150 class="negative">
											<a href="adm_oneview?date=${reservations.date}&room=1"> <strong><span style="color: yellowgreen;">${reservations.suitroom}</span></strong>
											</a></td>
										</c:otherwise>
									</c:choose>

									<c:choose>
										<c:when test="${reservations.doubleroom == '예약가능'}">
											<td width=150><span style="color:gray;">${reservations.doubleroom}</span></td>
										</c:when>
										<c:otherwise>
											<td width=150 class="negative">
											<a href="adm_oneview?date=${reservations.date}&room=2"> <strong><span style="color: yellowgreen;">${reservations.doubleroom}</span></strong>
											</a></td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${reservations.singleroom == '예약가능'}">
											<td width=150><span style="color:gray;">${reservations.singleroom}</span></td>
										</c:when>
										<c:otherwise>
											<td width=150 class="negative">
											<a href="adm_oneview?date=${reservations.date}&room=3"> <strong><span style="color: yellowgreen;">${reservations.singleroom}</span></strong>
											</a></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
			</tr>
		</table>
	</center>
	<!-- 	</div> -->
</body>
</html>
