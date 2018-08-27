<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>*사용자 등록</title>
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
	
	function checkNumber(str) {
		var number = /^0([1|7]?)0-?([0-9]{3,4})-?([0-9]{4})$/;
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
			alert("이름에 '<,>,;' 특수문자를 입력할 수 없습니다.");
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
		} else if(address.substr(0, 1) == ' ') {
			alert("주소 첫 글자에 공백은 올 수 없습니다.");
			user_insert.address.value = "";
			user_insert.address.focus();
			return false;
			//else if 조건으로 title의 첫글자가 ' '인 경우 경고창을 띄우고 false 값 반환
		} else if (checkSpecial(address) == false) {
			alert("주소에 '<,>,;' 특수문자를 입력할 수 없습니다.");
			user_insert.address.value = "";
			user_insert.address.focus();
			return false;
		} else if (number == "" || number == null) {
			alert("전화번호를 입력하세요.");
			user_insert.number.value = "";
			user_insert.number.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (checkNumber(number) == false) {
			alert("전화번호를 정확히 입력하세요.(ex)010(070)-1234-5678)");
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
	<h2>
		<center>사용자 등록</center>
	</h2>
	<form method=post name=user_insert>
		<table cellspacing=1 cellpadding=5 width=550 border=1 align=center>
			<tr>
				<td width=100 align=center><b>index</b></td>
				<td>신규(insert)
				<input type=hidden name=type value=insert_user></td>
			</tr>
			<tr>
				<td width=100 align=center><b>이름</b></td>
				<td><input type=text title="ex)꿀단지" name=name size=50 maxlength=70
					placeholder="이름을 입력하십시오." required></td>
			</tr>
			<tr>
				<td width=100 align=center><b>나이</b></td>
				<td><input type=number title="ex)20" name=age size=50 maxlength=70
					placeholder="나이를 입력하십시오." required></td>
			</tr>
				<tr>
				<td width=100 align=center><b>성별</b></td>
				<td>
				<input type="radio" name=gender value="M" checked="checked" />남자
				<input type="radio" name=gender value="W"  />여자
				</td>
			</tr>
			<tr>
				<td width=100 align=center><b>주소</b></td>
				<td><input type=text title="ex)경기도 구리시 ..." name=address size=60 maxlength=430
					placeholder="주소를 입력하십시오." required></td>
			</tr>
			<tr>
				<td width=100 align=center><b>전화번호</b></td>
				<td><input type=text title="ex)010(070)-1234-5678" name=number size=50 maxlength=50
					placeholder="전화번호를 입력하십시오." required></td>
			</tr>
				<tr>
				<td width=100 align=center><b>통신사</b></td>
				<td>
				<input type="radio" name=telecom_company value="KT" checked="checked" />KT
				<input type="radio" name=telecom_company value="SKT"  />SKT
				<input type="radio" name=telecom_company value="LGU+"  />LGU+
				</td>
			</tr>
		</table>

		<table width=550 align=center>
			<tr>
				<td width=500></td>
				<td align=right><input type=button value="취소"
					OnClick="location.href='list'"></td>
				<td align=right><input type=submit value="쓰기"
					OnClick="submitForm()">
					<input type=hidden name=error value=insert_user>
					</td>
			</tr>
		</table>
	</form>
</body>
</html>
