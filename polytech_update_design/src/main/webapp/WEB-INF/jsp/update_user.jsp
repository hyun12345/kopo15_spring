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

<title>*사용자 정보 수정</title>
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

	//'신규' 버튼 클릭시 실행되는 함수
	function submitForm() {
		var name = user_update.name.value;
		var age = user_update.age.value;
		var address = user_update.address.value;

		if (name == "" || name == null) {
			alert("이름을 입력하세요.");
			user_update.name.value = "";
			user_update.name.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (name.substr(0, 1) == ' ') {
			alert("이름 첫 글자에 공백은 올 수 없습니다.");
			user_update.name.value = "";
			user_update.name.focus();
			return false;
			//else if 조건으로 title의 첫글자가 ' '인 경우 경고창을 띄우고 false 값 반환
		} else if (checkSpecial(name) == false) {
			alert("이름은 한글 혹은 영어만 입력가능합니다.");
			user_update.name.value = "";
			user_update.name.focus();
			return false;
		} else if (age == '' || age == null) {
			alert("나이를 입력하세요.");
			user_update.age.value = '';
			user_update.age.focus();
			return false;
			//else if 조건으로 content 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (age > 100 || age < 0) {
			alert("나이는 0세부터 100세까지만 입력 가능합니다.");
			user_update.age.value = '';
			user_update.age.focus();
			return false;
			//else if 조건으로 content 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (address == "" || address == null) {
			alert("주소를 입력하세요.");
			user_insert.address.value = "";
			user_insert.address.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else {
			user_update.action = "write_update?key=" + ${userUpdate.id};
			//gongji_write form의 파라미터 전송 대상을 gongji_write.jsp?key=INSERT로 지정
			user_update.submit();
			//gongji_write form의 파라미터 전송
		}
	}
</script>
</head>
<body>
<br><br><br>
	<form method=post name=user_update>
		<center>
			<h1>
				[id : <span style="color: red;">${userUpdate.id}</span>]번 사용자 정보 수정
			</h1>
			<br>
			<div style='width: 600px;'>
				<table class="ui large celled definition table">
					<thead>
						<tr>
							<td class="one wide center aligned"><b>이름</b></td>
							<td class="three wide">
								<div class="ui small form">
									<input type=text name=name size=60 maxlength=10 value="${userUpdate.name}" required> 
								</div> 
								<input type=hidden name=type value=update_user>
							</td>
						</tr>
						<tr>
							<td class="one wide center aligned"><b>나이</b></td>
							<td class="three wide">
								<div class="ui small form">
									<input type=text name=age size=60 maxlength=10 value="${userUpdate.age}" required>
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
									<input type=text name=address size=60 maxlength=60 value="${userUpdate.address}" required>
								</div> 
							</td>
						</tr>
					</thead>
				</table>
			</div>
			<br>
			<table border=0 align=center>
				<tr>
					<td width=400></td>
					<td align=right>
						<input type=button class="small ui blue button" OnClick="location.href='list'" value="취소">
					</td>
					<td align=right>
						<button class="small ui blue button" OnClick="submitForm()">수정</button>
					</td>
					<td align=right>
						<button class="small ui blue button" OnClick="location.href='delete_user?key=${userUpdate.id}'">삭제</button>
					</td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>