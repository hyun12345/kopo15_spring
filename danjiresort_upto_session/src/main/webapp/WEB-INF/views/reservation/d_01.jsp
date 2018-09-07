<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- <!DOCTYPE html> -->
<html>
<head>
<title>*예약상황</title>

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>

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
   
   <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	function requestJson(id) {
		$.ajax({
			type : "GET",
			url : "https://openapi.gg.go.kr/Sidoatmospolutnmesure",
			async : false,
			contentType : "application/json; charset=utf-8",
			dataType : 'text',
			data : {
				"KEY" : "9df850cbc8ce49139b1c8059ffe8cb60",
				"Type" : "json",
				"pIndex" : "1",
				"pSize" : "100",
				"SIGUN_CD" : "41130"
			},
			success : function(json) {
				var obj = JSON.parse(json);
// 				console.log(obj);
// 				console.log(obj['Sidoatmospolutnmesure']);
// 				console.log(obj['Sidoatmospolutnmesure'][1]);
// 				console.log(obj['Sidoatmospolutnmesure'][1]['row']);
				console.log(obj['Sidoatmospolutnmesure'][1]['row'][0]);
// 				console.log(obj['Sidoatmospolutnmesure'][1]['row'][0]['FINEDUST_PM2_5_DNST_VL']);
				var value = obj['Sidoatmospolutnmesure'][1]['row'][0]['FINEDUST_PM2_5_DNST_VL'];
				$('#target').text(value);
			}
		});
	}	
</script>

</head>

<body style="background-color: #dbd5d9;">
<!-- <div style="background-image: url('resources/backgroundimg2.jpg'); background-size: cover; height: 100%;"> -->
	<%@include file="top.jsp"%>

	<center>
		<table border=0 align=center>
			<tr>
				<td colspan=4>
					<h2>예약상황</h2>
					<div align=right>
						<div id="target">미세먼지정도</div>
						<button class="small ui olive button" onclick="requestJson()">대기질 확인</button>
						<br>
					</div>
				</td>
			</tr>
			<tr><td>

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
							
								<c:choose>
									<c:when test="${reservations.suitroom == '예약가능'}">
											<td width=150>
												<a href="reservation_form?date=${reservations.date}&room=1">
													${reservations.suitroom}
												</a>
											</td>
										</c:when>
									<c:otherwise>
										<td width=150 class="negative">
											<strong><span style="color:yellowgreen;">${reservations.suitroom}</span></strong>
										</td>
									</c:otherwise>
								</c:choose>
							
								<c:choose>
									<c:when test="${reservations.doubleroom == '예약가능'}">
											<td width=150>
												<a href="reservation_form?date=${reservations.date}&room=2">
													${reservations.doubleroom}
												</a>
											</td>
									</c:when>
									<c:otherwise>
										<td width=150 class="negative">
											<strong><span style="color:yellowgreen;">${reservations.doubleroom}</span></strong>
										</td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${reservations.singleroom == '예약가능'}">
											<td width=150>
												<a href="reservation_form?date=${reservations.date}&room=3">
													${reservations.singleroom}
												</a>
											</td>
									</c:when>
									<c:otherwise>
										<td width=150 class="negative">
											<strong><span style="color:yellowgreen;">${reservations.singleroom}</span></strong>
										</td>
									</c:otherwise>
								</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table></td></tr>
		</table>
	</center>
<!-- 	</div> -->
</body>
</html>
