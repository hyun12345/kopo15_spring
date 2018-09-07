<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- <!DOCTYPE html> -->
<html>
<head>
<title>*welcome</title>

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
	<%@include file="top.jsp"%>

	<script>
	var name = '${user.name}'
	var timestamp = '${timestamp}'
		alert("'" + name + "'님 환영합니다.\n접속 시간 : " + timestamp);
		window.location.href="http://localhost:8181/danjiresort/main"
	</script>
</body>
</html>
