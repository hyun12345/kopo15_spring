<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- <!DOCTYPE html> -->
<html>
<head>
<title>*예약 불가</title>
</head>

<body>
	<c:choose>
		<c:when test="${type eq 'duplicate'}">
			<script>
				alert("예약이 완료된 방입니다. 다른 방을 선택하여 주십시오.");
				history.back();
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("예약 일자와 방을 선택하여 주십시오.");
				window.location.href="http://localhost:8181/danjiresort/reservation_list"
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>
