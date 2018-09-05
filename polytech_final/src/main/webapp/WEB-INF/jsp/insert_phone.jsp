<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>

<title>*전화번호 등록</title>
<style>
select {
	height: 21px;
	width: 200px;
}
</style>
<script language="JavaScript">
	//문자열 변수 대입하는 checkSpecial 함수 생성
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

	//'신규' 버튼 클릭시 실행되는 함수
	function submitForm() {
		var number = phone_insert.number.value;

		if (number == "" || number == null) {
			alert("전화번호를 입력하세요.");
			phone_insert.number.value = "";
			phone_insert.number.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (number.substr(0, 1) == ' ') {
			alert("전화번호 첫 글자에 공백은 올 수 없습니다.");
			phone_insert.number.value = "";
			phone_insert.number.focus();
			return false;
			//else if 조건으로 title의 첫글자가 ' '인 경우 경고창을 띄우고 false 값 반환
		} else if (checkNumber(number) == false) {
			alert("전화번호를 정확히 입력하세요.(ex)010(070)-1234-5678)");
			phone_insert.number.value = "";
			phone_insert.number.focus();
			return false;
		} else {
			phone_insert.action = "write_insert";
			//gongji_write form의 파라미터 전송 대상을 gongji_write.jsp?key=INSERT로 지정
			phone_insert.submit();
			//gongji_write form의 파라미터 전송
		}
	}
</script>
</head>

<body>
<br><br><br>
	<form method=post name=phone_insert>
		<center>
			<h1>
				[<span style="color: red;">${insertPhone.name}</span>] 사용자 전화번호 등록
			</h1>
			<br>
			<div style='width: 400px;'>
				<table class="ui large celled definition table">
					<tr>
						<td class="center aligned"><b>phone_id</b></td>
						<td>신규(insert) <input type=hidden name=type
							value=insert_phone></td>
					</tr>
					<tr>
						<td class="center aligned"><b>전화번호</b></td>
						<td>
							<div class="ui small form">
								<input type=text title="ex)010(070)-1234-5678" name=number size=30 maxlength=20 placeholder="전화번호를 입력하십시오." required> 
							</div> 
							<input type=hidden name=user_id value="${insertPhone.id}"></td>
					</tr>
					<tr>
						<td class="center aligned"><b>통신사</b></td>
						<td>
							<div class="ui radio checkbox">
								<input type="radio" name=telecom_company value="KT" checked="checked" />
								<label>KT &nbsp;</label>
							</div>
							<div class="ui radio checkbox">
								<input type="radio" name=telecom_company value="SKT" />
								<label>SKT&nbsp;</label>
							</div>
							<div class="ui radio checkbox">
								<input type="radio" name=telecom_company value="LGU+" />
								<label>LGU+&nbsp;</label>
							</div>
						</td>
					</tr>
				</table>
			</div>
				<table align=center>
					<tr>
						<td width=250></td>
						<td align=right>
							<input type=button class="small ui blue button" OnClick="location.href='list'" value="취소">
						</td>
						<td align=right>
							<input type=button class="small ui blue button" OnClick="submitForm()" value="쓰기">
						</td>
					</tr>
				</table>
		</center>
	</form>
</body>
</html>
