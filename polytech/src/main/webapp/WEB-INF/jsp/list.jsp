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
<style type="text/css">
a {
	text-decoration: none
}
</style>
<script language="JavaScript">
	//문자열 변수 대입하는 checkSpecial 함수 생성

	function checkSpecial(str) {
		var specialstring = /[<|>|;]/gi;
		//변수 specialstring의 값을 '<>;'의 특수문자 정규표현식으로 설정
		var isValid = true;
		//변수 isValid의 값을 true로 설정
		if (specialstring.test(str)) {
			//.test(str) : str에 해당 패턴이 있는지 여부를 나타내는 메소드
			isValid = false;
			//대입한 변수에 특수문자가 존재하면 false값을 isValid 변수의 값으로 저장
		}
		return isValid;
		//isValid 변수 반환   
	}
	
	//'신규' 버튼 클릭시 실행되는 함수
	function submitForm_user() {
		var name = searching.searching_user.value;

		if (name == "" || name == null) {
			alert("이름을 입력하세요.");
			searching.name.value = "";
			searching.name.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (name.substr(0, 1) == ' ') {
			alert("이름 첫 글자에 공백은 올 수 없습니다.");
			searching.name.value = "";
			searching.name.focus();
			return false;
			//else if 조건으로 title의 첫글자가 ' '인 경우 경고창을 띄우고 false 값 반환
		} else if (checkSpecial(name) == false) {
			alert("이름에 '<,>,;' 특수문자를 입력할 수 없습니다.");
			searching.name.value = "";
			searching.name.focus();
			return false;
		} else {
			searching.action = "search_result?type=user";
			//gongji_write form의 파라미터 전송 대상을 gongji_write.jsp?key=INSERT로 지정
			searching.submit();
			//gongji_write form의 파라미터 전송
		}
	}

	function checkNumber(str) {
		var number = /^\d{2,3}-\d{3,4}-\d{4}$/;
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
	function submitForm_phone() {
		var number = searching.searching_phone.value;

		if (number == "" || number == null) {
			alert("전화번호를 입력하세요.");
			searching.number.value = "";
			searching.number.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (number.substr(0, 1) == ' ') {
			alert("전화번호 첫 글자에 공백은 올 수 없습니다.");
			searching.number.value = "";
			searching.number.focus();
			return false;
			//else if 조건으로 title의 첫글자가 ' '인 경우 경고창을 띄우고 false 값 반환
		} else if (checkNumber(number) == false) {
			alert("전화번호를 정확히 입력하세요.(ex)010-1234-5678)");
			searching.number.value = "";
			searching.number.focus();
			return false;
		} else {
			searching.action = "search_result?type=phone";
			//gongji_write form의 파라미터 전송 대상을 gongji_write.jsp?key=INSERT로 지정
			searching.submit();
			//gongji_write form의 파라미터 전송
		}
	}
</script>

</head>
<body>
	<center>
		<h1>사용자 리스트</h1>
	</center>
	<br>
	<form method=post name=searching>
		<table align=center>
			<tr>
				<td width=80></td>
				<td align=right>
				<input type=search title="ex)꿀단지" placeholder="조회할 사용자 이름"name=searching_user> 
				<input type=submit value="검색" OnClick="submitForm_user()">
				<input type=hidden name=type value="user"></td>
			</tr>
			<tr>
				<td width=80></td>
				<td align=right>
				<input type=search title="ex)010-1234-5678" placeholder="조회할 전화번호" name=searching_phone> 
				<input type=submit value="검색" OnClick="submitForm_phone()">
				<input type=hidden name=type value="phone"></td>
			</tr>
		</table>
	</form>
	<br>
	<table cellspacing=1 cellpadding=5 width=300 border=1 align=center>
		<tbody align=center>
			<tr>
				<td width=100><b>No.</b></td>
				<td width=200><b>Name</b></td>
			</tr>
			<c:forEach items="${userList}" var="userList" varStatus="status">
				<tr>
					<td width=100>${status.count}
					<input type=hidden name=index value="${status.count}"></td>
					<td width=200><a href="view?key=${userList.id}">
							${userList.name} </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<table width=300 align=center>
		<tr>
			<td width=230></td>
			<td align=right><input type=button value="사용자 등록"
				OnClick="location.href='insert_user'"></td>

		</tr>
	</table>
</body>
</html>