<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>*전화번호 수정</title>
<style>
select {
	height: 20px;
	width: 200px;
}
</style>

<script language="JavaScript">
	//문자열 변수 대입하는 checkSpecial 함수 생성
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
	function submitForm() {
		var number = phone_update.number.value;
		var user_id = phone_update.user_id.value;
		var telecom_company = phone_update.telecom_company.value;
		
// 		var isValid = true;
// 		var number_list = ["${phoneList.number}"];

		if (number == "" || number == null) {
			alert("전화번호를 입력하세요.");
			phone_update.number.value = "";
			phone_update.number.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else if (number.substr(0, 1) == ' ') {
			alert("전화번호 첫 글자에 공백은 올 수 없습니다.");
			phone_update.number.value = "";
			phone_update.number.focus();
			return false;
			//else if 조건으로 title의 첫글자가 ' '인 경우 경고창을 띄우고 false 값 반환
		} else if (checkNumber(number) == false) {
			alert("전화번호를 정확히 입력하세요.(ex)010-1234-5678)");
			phone_update.number.value = "";
			phone_update.number.focus();
			return true;
		} else if (user_id == "" || user_id == null) {
			alert("전화번호 사용자를 선택하세요.");
			phone_update.user_id.value = "";
			phone_update.user_id.focus();
			return false;
			//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
		} else {
			phone_update.action = "write_update?key=" + ${phoneUpdate.id};
			//gongji_write form의 파라미터 전송 대상을 gongji_write.jsp?key=INSERT로 지정
			phone_update.submit();
			//gongji_write form의 파라미터 전송
		}
	}
</script>
</head>
<body>
	<form method=post name=phone_update>
		<table border=0 align=center>
			<tr>
				<td>
					<center>
						<h2>
							[<span style="color: red;">${phoneUpdate.id}</span>]번 전화번호 수정
						</h2>
					</center>
				</td>
			</tr>
			<tr>
				<table cellspacing=1 cellpadding=5 width=550 border=1 align=center>
					<tr>
						<td width=100 align=center><b>전화번호</b></td>
						<td><input type=text name=number size=50 maxlength=70
							value="${phoneUpdate.number}" required> <input
							type=hidden name=type value=update_phone></td>
					</tr>
					<tr>
						<td width=100 align=center><b>통신사</b></td>
						<td><input type="radio" name=telecom_company value="KT" checked="checked" />KT 
						<input type="radio" name=telecom_company value="SKT" />SKT 
						<input type="radio" name=telecom_company value="LGU+" />LGU+</td>
					</tr>
					<tr>
						<td width=100 align=center><b>사용자</b></td>
						<td><select name="user_id">
								<option value="${phoneUpdate.user.id}">${phoneUpdate.user.id} : ${phoneUpdate.user.name}</option>
								<c:forEach items="${userList}" var="userList">
									<option value="${userList.id}">${userList.id} : ${userList.name}</option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
			</tr>
		</table>
		<br>
		<table border=0 align=center>
			<tr>
				<td width=400></td>
				<td align=right><input type=button value="취소"
					OnClick="location.href='list'"></td>
				<td align=right><input type=submit value="수정"
					OnClick="submitForm()"></td>
				<td align=right><input type=button value="삭제"
					OnClick="location.href='delete_phone?key=${phoneUpdate.id}'"></td>
			</tr>
		</table>
	</form>
</body>
</html>