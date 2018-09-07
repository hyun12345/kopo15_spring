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
		<c:when test="${type eq 'login'}">
			<script>
				alert("ID / password가 틀렸습니다.");
				history.back();
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("이미 로그인한 상태입니다.");
				window.location.href="http://localhost:8181/danjiresort/main"
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>
