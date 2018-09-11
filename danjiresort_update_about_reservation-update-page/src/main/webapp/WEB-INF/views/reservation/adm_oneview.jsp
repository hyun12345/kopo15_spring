<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- <!DOCTYPE html> -->
<html>
<head>
<title>*예약상세</title>

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
	//문자열 변수 대입하는 checkSpecial 함수 생성
	function checkSpecial(str) {
		var name = /^[a-zA-Z가-힣]+$/;
		//변수 specialstring의 값을 '<>;'의 특수문자 정규표현식으로 설정
		var isValid = true;
		//변수 isValid의 값을 true로 설정
		if (name.test(str)) {
			//.test(str) : str에 해당 패턴이 있는지 여부를 나타내는 메소드
			isValid = true;
			//대입한 변수에 특수문자가 존재하면 false값을 isValid 변수의 값으로 저장
		} else if (!name.test(str)) {
			isValid = false;
		}
		return isValid;
		//isValid 변수 반환   
	}

	function checkNumber(str) {
		var number = /^0([1|7]?)([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
		//변수 specialstring의 값을 '<>;'의 특수문자 정규표현식으로 설정
		var isValid = true;
		//변수 isValid의 값을 true로 설정
		if (number.test(str)) {
			//.test(str) : str에 해당 패턴이 있는지 여부를 나타내는 메소드
			isValid = true;
			//대입한 변수에 특수문자가 존재하면 false값을 isValid 변수의 값으로 저장
		} else if (!number.test(str)) {
			isValid = false;
		}
		return isValid;
		//isValid 변수 반환   
	}

	//'수정' 버튼 클릭시 실행되는 함수
	function submitForm() {
		var name = adm_oneview_update.name.value;
		var address = adm_oneview_update.address.value;
		var number = adm_oneview_update.number.value;

		if (name == "" || name == null) {
			alert("이름을 입력하세요.");
			adm_oneview_update.name.value = "";
			adm_oneview_update.name.focus();
			return false;
		} else if (name.substr(0, 1) == ' ') {
			alert("이름 첫 글자에 공백은 올 수 없습니다.");
			adm_oneview_update.name.value = "";
			adm_oneview_update.name.focus();
			return false;
		} else if (checkSpecial(name) == false) {
			alert("이름은 한글 혹은 알파벳만 입력가능합니다.");
			adm_oneview_update.name.value = "";
			adm_oneview_update.name.focus();
			return false;
		} else if (address == "" || address == null) {
			alert("주소를 입력하세요.");
			adm_oneview_update.address.value = "";
			adm_oneview_update.address.focus();
			return false;
		} else if (address.substr(0, 1) == ' ') {
			alert("주소 첫 글자에 공백은 올 수 없습니다.");
			adm_oneview_update.address.value = "";
			adm_oneview_update.address.focus();
			return false;
		} else if (number == "" || number == null) {
			alert("전화번호를 입력하세요.");
			adm_oneview_update.number.value = "";
			adm_oneview_update.number.focus();
			return false;
		} else if (checkNumber(number) == false) {
			alert("전화번호를 정확히 입력하세요.(ex)010-1234-5678)");
			adm_oneview_update.number.value = "";
			adm_oneview_update.number.focus();
			return false;
		} else {
			adm_oneview_update.action = "adm_update?key=" + ${reservation.id};
			adm_oneview_update.submit();
		}
	}
</script>
</head>

<body>
	<%@include file="top.jsp"%>
	<form method=post name=adm_oneview_update>
		<center>
			<br><br><br>
			<h2>예약 상세</h2>
			<br>

			<div style='width: 600px;'>
				<table class="ui small pink table">
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>예약번호</b></td>
						<td>${reservation.id}</td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>성명</b></td>
						<td><div class="ui small form">
								<input type=text name=name value="${reservation.user.name}" required title="ex)냠냠" size=70 maxlength=70> 
								<input type=hidden name=user_id value="${reservation.user.id }">
							</div></td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>예약일자</b></td>
						<td><select name="date" class="ui dropdown">
								<c:forEach items="${reservations}" var="reservations">
									<option value="${reservations.date}" <c:if test="${reservations.date eq date}">selected</c:if>>${reservations.date}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>예약방</b></td>
						<td><select name="room_id" class="ui dropdown">
								<c:forEach items="${roomList}" var="roomList">
									<option value="${roomList.id}" <c:if test="${roomList.id eq reservation.room.id}">selected</c:if>>${roomList.type}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>주소</b></td>
						<td><div class="ui small form">
								<input type=text name=address value="${reservation.user.addr}" required title="ex)우리집" size=70 maxlength=70>
							</div></td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>전화번호</b></td>
						<td><div class="ui small form">
								<input type=text name=number value="${reservation.user.telnum}" required title="ex)010-1234-5678" size=70 maxlength=70>
							</div></td>
					</tr>
					<tr>
						<td width=100 align=center style="background-color: #dbd5d9;"><b>남기실말</b></td>
						<td><div class="ui small form">
								<input type=text name=comment value="${reservation.comment}" title="ex)전망 좋은 방으로 주세요." size=70 maxlength=70>
							</div></td>
					</tr>
				</table>

				<table>
					<tr>
						<td><br> 
							<input type=button class="small ui olive button" OnClick="location.href='adm_allview'" value="관리자페이지">
							<input type=button class="small ui olive button" OnClick="submitForm()" value="수정">
							<input type=button class="small ui olive button" OnClick="location.href='adm_delete?key=${reservation.id}'" value="삭제"></td>
					</tr>
				</table>
			</div>
		</form>
	</center>
</body>
</html>
