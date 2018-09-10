<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session = "true" %>

<!-- <!DOCTYPE html> -->
<html>
<head>
<title>*welcome</title>

</head>
<body>
	<%@include file="top.jsp"%>

	<script>
	var name = '${user.name}'
	var timestamp = '${timestamp}'
		alert("'" + name + "'님 환영합니다.\n접속 시간 : " + timestamp);
		location.href="main"
	</script>
</body>
</html>
