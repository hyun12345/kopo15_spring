<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>*게시글수정</title>
<script language="JavaScript">
 //문자열 변수 대입하는 checkSpecial 함수 생성
 function checkSpecial(str) {
          var specialstring = /[<|>|;]/gi;
           //변수 specialstring의 값을 '<>;'의 특수문자 정규표현식으로 설정
          var isValid = true;
          //변수 isValid의 값을 true로 설정
          if(specialstring.test(str)) {
            //.test(str) : str에 해당 패턴이 있는지 여부를 나타내는 메소드
             isValid = false;
            //대입한 변수에 특수문자가 존재하면 false값을 isValid 변수의 값으로 저장
          }
         return isValid;
        //isValid 변수 반환   
      }

    //'신규' 버튼 클릭시 실행되는 함수
    function submitForm(){
    var title = gongji_update.title.value;
    var content = gongji_update.content.value;
    
        if(title == "" || title == null){
        	alert("제목을 입력하세요.");
        	gongji_update.title.value="";
        	gongji_update.title.focus();
        	return false;
        	//if 조건으로 title 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
        } else if (title.substr(0,1) == ' ') {
        	alert("첫 글자에 공백은 올 수 없습니다.");  
        	gongji_update.title.value="";
        	gongji_update.title.focus();
        	return false;
        	//else if 조건으로 title의 첫글자가 ' '인 경우 경고창을 띄우고 false 값 반환
        } else if(checkSpecial(title) == false) {
        	alert("제목에 '<,>,;' 특수문자를 입력할 수 없습니다.");
        	gongji_update.title.value="";
        	gongji_update.title.focus();
        	return false;
        } else if(content == "" || content == null){
        	alert("내용을 입력하세요.");
        	gongji_update.content.value="";
        	gongji_update.content.focus();
        	return false;
        	//else if 조건으로 content 값이 입력되지 않았을 때 이와 같은 경고창을 띄우고 false 값 반환
        } else if(checkSpecial(content) == false) {
            alert("내용에 '<,>,;' 특수문자를 입력할 수 없습니다.");
            gongji_update.content.value="";
            gongji_update.content.focus();
            return false;
        } else {
        	gongji_update.action = "gongji_wrtie_update?key=" + ${gongjiUpdate.id};
        	//gongji_write form의 파라미터 전송 대상을 gongji_wrtie_update?key=id값으로 지정
        	gongji_update.submit();                
        	//gongji_write form의 파라미터 전송
        }
    }
</script>
</head>
<body>
<h2><center>게시글수정</center></h2>
<form method=post name=gongji_update>
<table cellspacing=1 cellpadding=5 width=550 border=1 align=center>
		<tr>
			<td width=100 align=center><b>번호</b></td>
			<td colspan=3>${gongjiUpdate.id}<input type=hidden name=id size=70 value="${gongjiUpdate.id}"></td>
<!-- 			<input type=hidden name=key value="UPDATE" readonly> -->
		</tr>
		<tr>
			<td width=100 align=center><b>작성자</b></td>
			<td colspan=3>${gongjiUpdate.user.name}
			<input type=hidden size=70 maxlength=70 placeholder="ID를 입력하십시오." required>
			</td>
    	<tr>
			<td width=100 align=center><b>제목</b></td>
			<td colspan=3><input type=text name=title size=70 maxlength=70 value="${gongjiUpdate.title}" required></td>
		</tr>
		<tr>
			<td width=100 align=center><b>일자</b></td>
			<td colspan=3><fmt:formatDate value="${update_date}" pattern="yyyy-MM-dd" /></td>
		</tr>
		<tr>
			<td width=100 align=center><b>조회수</b></td>
			<td colspan=3>${gongjiUpdate.viewcnt}</td>
		</tr>
		<tr>
			<td width=100 align=center><b>내용</b></td>
			<td colspan=3><textarea style="width:440px; height:250px;" name=content cols=70 rows=600 required>${gongjiUpdate.content}</textarea></td>
		</tr>
		<c:if test="${gongjiUpdate.relevel > 0}">
		<tr>
			<td width=100 align=center><b>원글</b></td>
			<td>${gongjiUpdate.rootid}</td>
			<td width=100 align=center><b>부모글</b></td>
			<td>${gongjiUpdate.parent.id}</td>
		</tr>
		<tr>
		<td width=100><b>댓글수준</b></td>
		<td>${gongjiUpdate.relevel}</td>
    	<td width=100><b>댓글내 순서</b></td>
    	<td>${gongjiUpdate.recnt}</td></tr>
    	</c:if>
</table>

<table width=550 align=center>
<tr>
<td width=540></td>
<td align=right><input type=button value="취소" OnClick="location.href='gongji_list'"></td>
<td align=right><input type=button value="수정" OnClick="submitForm()"></td>
<td align=right><input type=button value="삭제" OnClick="location.href='gongji_delete?key=${gongjiUpdate.id}'"></td>
</tr>
</table>
</form>
</body>
</html>
