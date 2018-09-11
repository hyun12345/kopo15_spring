<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- <!DOCTYPE html> -->
<html>
<head>
<title>*로그인</title>

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>

<style>

select {
	width: 200px;
}
</style>

<script language="JavaScript">
	//'로그인' 버튼 클릭시 실행되는 함수
	function submitForm() {
		var id = login.id.value;
		var password = login.password.value;

		if (id == "" || id == null) {
			alert("ID를 입력하세요.");
			login.id.value = "";
			login.id.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (id.substr(0, 1) == ' ') {
			alert("ID 첫 글자에 공백은 올 수 없습니다.");
			login.id.value = "";
			login.id.focus();
			return false;
			//else if 조건으로 title의 첫글자가 ' '인 경우 경고창을 띄우고 false 값 반환
		} else if (password == "" || password == null) {
			alert("password를 입력하세요.");
			login.password.value = "";
			login.password.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (password.substr(0, 1) == ' ') {
			alert("password 첫 글자에 공백은 올 수 없습니다.");
			login.password.value = "";
			login.password.focus();
			return false;
		} else {
			login.action = "welcome";
			//gongji_write form의 파라미터 전송 대상을 gongji_write.jsp?key=INSERT로 지정
			login.submit();
			//gongji_write form의 파라미터 전송
		}
	}
</script>

</head>

<body>
	<%@include file="top.jsp"%>
	<form method=post name=login>
		<center>
			<br>
			<br>
			<br>
			<h2>로그인</h2>
			<br>
			<div style='width: 350px;'>
				<table class="ui small pink table">
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>ID</b></td>
						<td><div class="ui small form">
								<input type=text name=id placeholder="please insert your ID" title="ex)user" required>
							</div></td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>password</b></td>
						<td><div class="ui small form">
								<input type=password name=password placeholder="please insert your password" title="ex)9999" required>
							</div></td>
					</tr>
				</table>

				<table>
					<tr>
						<td><br>
							<button class="small ui olive button" OnClick="submitForm()">로그인</button></td>
					</tr>
				</table>
				</div>
	</form>
	</center>
</body>
</html>
