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

<title>*사용자 등록</title>
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

	//'신규' 버튼 클릭시 실행되는 함수
	function submitForm() {
		var name = user_insert.name.value;
		var age = user_insert.age.value;
		var address = user_insert.address.value;

		var number = user_insert.number.value;

		if (name == "" || name == null) {
			alert("이름을 입력하세요.");
			user_insert.name.value = "";
			user_insert.name.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (name.substr(0, 1) == ' ') {
			alert("이름 첫 글자에 공백은 올 수 없습니다.");
			user_insert.name.value = "";
			user_insert.name.focus();
			return false;
			//else if 조건으로 title의 첫글자가 ' '인 경우 경고창을 띄우고 false 값 반환
		} else if (checkSpecial(name) == false) {
			alert("이름은 한글 혹은 영어만 입력가능합니다.");
			user_insert.name.value = "";
			user_insert.name.focus();
			return false;
		} else if (age == '' || age == null) {
			alert("나이를 입력하세요.");
			user_insert.age.value = '';
			user_insert.age.focus();
			return false;
			//else if 조건으로 content 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (age > 100 || age < 0) {
			alert("나이는 0세부터 100세까지만 입력 가능합니다.");
			user_insert.age.value = '';
			user_insert.age.focus();
			return false;
			//else if 조건으로 content 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (address == "" || address == null) {
			alert("주소를 입력하세요.");
			user_insert.address.value = "";
			user_insert.address.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (address.substr(0, 1) == ' ') {
			alert("주소 첫 글자에 공백은 올 수 없습니다.");
			user_insert.address.value = "";
			user_insert.address.focus();
			return false;
			//else if 조건으로 title의 첫글자가 ' '인 경우 경고창을 띄우고 false 값 반환
		} else if (number == "" || number == null) {
			alert("전화번호를 입력하세요.");
			user_insert.number.value = "";
			user_insert.number.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (checkNumber(number) == false) {
			alert("전화번호를 정확히 입력하세요.(ex)010-1234-5678)");
			user_insert.number.value = "";
			user_insert.number.focus();
			return false;
		} else {
			user_insert.action = "write_insert";
			//gongji_write form의 파라미터 전송 대상을 gongji_write.jsp?key=INSERT로 지정
			user_insert.submit();
			//gongji_write form의 파라미터 전송
		}
	}
</script>
</head>

<body>
<br><br><br>
	<center>
		<h1>사용자 등록</h1>
		<form method=post name=user_insert>
			<div style='width: 600px;'>
				<table class="ui large celled definition table">
				<thead>
				<tr>
					<td class="one wide center aligned"><b>user_id</b></td>
					<td class="three wide">신규(insert) <input type=hidden name=type value=insert_user></td>
				</tr>
				<tr>
					<td class="one wide center aligned"><b>이름</b></td>
					<td class="three wide">
						<div class="ui small form">
							<input type=text title="ex)꿀단지" name=name size=60 maxlength=10 placeholder="이름을 입력하십시오." required>
						</div> 
					</td>
				</tr>
				<tr>
					<td class="one wide center aligned"><b>나이</b></td>
					<td class="three wide">
						<div class="ui small form">
							<input type=number title="ex)20" name=age size=60 maxlength=10 placeholder="나이를 입력하십시오." required>
						</div> 
					</td>
				</tr>
				<tr>
					<td class="one wide center aligned"><b>성별</b></td>
					<td class="three wide">
						<div class="ui radio checkbox">
							<input type="radio" name=gender value="M" checked="checked" />
							<label>남자 &nbsp;&nbsp; </label>
						</div>
						<div class="ui radio checkbox">
							<input type="radio" name=gender value="W" />
							<label>여자</label>
						</div>
					</td>
				</tr>
				<tr>
					<td class="one wide center aligned"><b>주소</b></td>
					<td class="three wide">
						<div class="ui small form">
							<input type=text title="ex)경기도 구리시 ..." name=address size=60 maxlength=60 placeholder="주소를 입력하십시오." required>
						</div> 
					</td>
				</tr>
				<tr>
					<td class="one wide center aligned"><b>전화번호</b></td>
					<td class="three wide">
						<div class="ui small form">
							<input type=text title="ex)010-1234-5678" name=number size=60 maxlength=20 placeholder="전화번호를 입력하십시오." required>
						</div> 
					</td>
				</tr>
				<tr>
					<td class="one wide center aligned"><b>통신사</b></td>
					<td class="three wide">
						<div class="ui radio checkbox">
							<input type="radio" name=telecom_company value="KT" checked="checked" />
							<label>KT &nbsp; </label>
						</div>
						<div class="ui radio checkbox">
							<input type="radio" name=telecom_company value="SKT" />
							<label>SKT &nbsp;</label>
						</div>
						<div class="ui radio checkbox">
							<input type="radio" name=telecom_company value="LGU+" />
							<label>LGU+ &nbsp;</label>
						</div>
					</td>
				</tr>
			</table>

			<table width=550 align=center>
				<tr>
					<td width=400></td>
					<td align=right>
						<input type=button class="small ui blue button" value="취소" OnClick="location.href='list'">
					</td>
					<td align=right>
						<button class="small ui blue button" OnClick="submitForm()">쓰기</button>
						<input type=hidden name=error value=insert_user>
					</td>
				</tr>
			</table>
		</div>
	</form>
</center>
</body>
</html>
