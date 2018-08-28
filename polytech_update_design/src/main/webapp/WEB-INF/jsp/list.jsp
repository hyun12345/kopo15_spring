<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>*리스트</title>

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>

<style type="text/css">
a {
	text-decoration: none
}
</style>

<script language="JavaScript">
//문자열 변수 대입하는 checkSpecial 함수 생성
function checkSpecial(str) {
	var name = /^[a-zA-Z가-힣]+$/; 
	//변수 name의 값을 모든 알파벳, 한글 정규표현식으로 설정
	var isValid = true;
	//변수 isValid의 값을 true로 설정
	if (name.test(str)) {
		//.test(str) : str에 해당 패턴이 있는지 여부를 나타내는 메소드
		isValid = true;
		//대입한 변수에 해당 문자가 존재하면 true값을 isValid 변수의 값으로 저장
	} else if (!name.test(str)) {
		isValid = false;
	}
	return isValid;
	//isValid 변수 반환   
}

	//'겁색(사용자)' 버튼 클릭시 실행되는 함수
	function submitForm_user() {
		var name = searching.searching_user.value;

		if (name == "" || name == null) {
			alert("이름을 입력하세요.");
			searching.name.value = "";
			searching.name.focus();
			return false;
			//if 조건으로 name 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (name.substr(0, 1) == ' ') {
			alert("이름 첫 글자에 공백은 올 수 없습니다.");
			searching.name.value = "";
			searching.name.focus();
			return false;
			//else if 조건으로 name의 첫글자가 ' '(공백)인 경우 경고창을 띄우고 false 값 반환
		} else if (checkSpecial(name) == false) {
			alert("이름은 한글 혹은 영어만 입력가능합니다.");
			searching.name.value = "";
			searching.name.focus();
			return false;
		} else {
			searching.action = "search_result?type=user";
			//searching form의 파라미터 전송 대상을 search_result?type=user로 지정
			searching.submit();
			//searching form의 파라미터 전송
		}
	}

	function checkNumber(str) {
		var number = /^0([1|7]?)([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
		//변수 number의 값을 핸드폰 앞자리 3자리 수-3자리 혹은 4자리 수-네자리 수 로 설정
		var isValid = true;
		//변수 isValid의 값을 true로 설정
		if (number.test(str)) {
			//.test(str) : str에 해당 패턴이 있는지 여부를 나타내는 메소드
			isValid = true;
			//대입한 값이 변수 number 패턴과 일치하면 true값을 isValid 변수의 값으로 저장
		} else if (!number.test(str)) {
			isValid = false;
			//그렇지 않을 경우 false값을 isValid 변수의 값으로 저장
		}
		return isValid;
		//isValid 변수 반환   
	}

	//'겁색(전화번호)' 버튼 클릭시 실행되는 함수
	function submitForm_phone() {
		var number = searching.searching_phone.value;

		if (number == "" || number == null) {
			alert("전화번호를 입력하세요.");
			searching.number.value = "";
			searching.number.focus();
			return false;
			//if 조건으로 number 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (number.substr(0, 1) == ' ') {
			alert("전화번호 첫 글자에 공백은 올 수 없습니다.");
			searching.number.value = "";
			searching.number.focus();
			return false;
			//else if 조건으로 number의 첫글자가 ' '(공백)인 경우 경고창을 띄우고 false 값 반환
		} else if (checkNumber(number) == false) {
			alert("전화번호를 정확히 입력하세요.(ex)010(070)-1234-5678)");
			searching.number.value = "";
			searching.number.focus();
			return false;
		} else {
			searching.action = "search_result?type=phone";
			//searching form의 파라미터 전송 대상을search_result?type=phone로 지정
			searching.submit();
			//searching form의 파라미터 전송
		}
	}
</script>
</head>
<body>
<br><br><br>
	<center>
	<h1>사용자 리스트</h1><br><br>
		<table align=center border=0>
			<form method=post name=searching>
				<table align=center>
					<tr>
						<td>
						<div class="ui search">
							<div class="ui icon input">
								<input type=search title="ex)꿀단지" placeholder="조회할 사용자 이름" name=searching_user>
								<i class="search icon"></i>
							</div>
							<div class="results"></div>
							<button class="small ui olive button" OnClick="submitForm_user()">검색</button>
							<input type=hidden name=type value="user"><br>
						</div>
					</td>
						<td>
							<div class="ui search">
							<div class="ui icon input">
								<input type=search title="ex)010-1234-5678" placeholder="조회할 전화번호" name=searching_phone>
								<i class="search icon"></i>
							</div>
							<div class="results"></div>
							<button class="small ui olive button" OnClick="submitForm_phone()">검색</button>
							<input type=hidden name=type value="phone">
						</div>
					</td>	
					</tr>
				</table>
			</form>
			<br><br>
			<div style='height: 500px; width: 400px;'>
				<table class="ui large celled table">
					<tbody align=center>
					<thead>
						<tr class="center aligned">
							<th class="one wide"><b>No.</b></th>
							<th class="one wide"><b>Name</b></th>
						</tr>
					</thead>
					<c:forEach items="${userList}" var="userList" varStatus="status">
						<tr class="center aligned">
							<td width=100>${status.count}
							</td>
							<td width=100><a href="view?key=${userList.id}">
									${userList.name} </a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<table align=center>
					<tr>
						<td width=280></td>
						<td align=right>
							<button class="small ui violet button" OnClick="location.href='insert_user'">사용자 등록</button>
						</td>
					</tr>
				</table>
			</div>
		</table>
	</center>
</body>
</html>