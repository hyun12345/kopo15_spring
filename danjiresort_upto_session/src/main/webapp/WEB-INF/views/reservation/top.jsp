<!--k15전아현 / 2018.08.01.-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <!DOCTYPE html> -->
<html>

<head>
    <title> 홈페이지 테스트</title>
    
    <link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>

<style>
        body {
            /* The image used */
            background-image: url("resources/backgroundimg2.jpg");
    
            /* Full height */
            height: 100%;
    
            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
   </style>
    
<!--     <style type="text/css"> -->
<!--         /* td { -->
<!--             font-size: 12; -->
<!--             text-align: center; -->
<!--         } */ -->

<!--         a:link { -->
<!--             text-decoration: none; -->
<!--         } -->

<!--         a:visited { -->
<!--             text-decoration: none; -->
<!--         } -->

<!--         a:hover { -->
<!--             text-decoration: none; -->
<!--         } -->

<!--         a:active { -->
<!--             text-decoration: none; -->
<!--         } -->

<!--         a { -->
<!--             text-decoration: none; -->
<!--         } -->
<!--     </style> -->

    <script language='javascript' type='text/javascript'>
        var muCnt = 5;

        function fncShow(pos) {
            var i = 0;
            for (i; i < muCnt; i++) {
                var obj1 = document.getElementById("menu" + i);
                var obj2 = document.getElementById("m" + i);
                if (i == pos) {
                    obj1.style.display = '';
                    obj2.style.color = "#92B3B7";
                } else {
                    obj1.style.display = 'none';
                    obj2.style.color = "#102d51";
                }
            }
        }

        function fncHide(pos) {
            var obj = document.getElementById("menu" + pos);
            obj.style.display = 'none';
        }
    </script>
</head>

<body bgcolor="#dbd5d9">
    <center>
        <table cellpadding='0' cellspacing='1' border='0'>
            <td width='150' align=center>
                <a href='main'>
                    <img src="/danjiresort/resources/danji.png" width='140' height='50' border='0'>
                </a>
            </td>
            <td>

                <table cellpadding='0' cellspacing='1' border='0' width='900' height='60' style='font-size:15pt; font-weight:bold; text-align: center;'>
                    <tr height='30'>
                        <td width='150' onmouseover='fncShow(0);' id='m0'>
                            <b> 리조트소개 </b>
                        </td>
                        <td width='150' onmouseover='fncShow(1);' id='m1'>
                            <b> 찾아오기 </b>
                        </td>
                        <td width='150' onmouseover='fncShow(2);' id='m2'>
                            <b> 주변여행지 </b>
                        </td>
                        <td width='150' onmouseover='fncShow(3);' id='m3'>
                            <b> 예약하기 </b>
                        </td>
                        <td width='150' onmouseover='fncShow(4);' id='m4'>
                            <b> 리조트소식 </b>
                        </td>
                        <c:choose>
                        <c:when test="${auth == null}">
                        <td>
							<input type=button class="mini ui olive button" onclick="location.href='login'" value="login"> 
						</td>
						</c:when>
						<c:otherwise>
						<td>
							<c:if test="${auth eq 'admin'}">
							<div style="font-size:15; color:red;">*${user.name}*</div>
							</c:if>
							<c:if test="${auth ne 'admin'}">
							<div style="font-size:15; color:orange;">${user.name}</div>
							</c:if>
							<div style="font-size:10;">님 환영합니다.</div>
						</td>
						<td>
							<input type=button class="mini ui olive button" onclick="location.href='logout'" value="logout">
						</td>
						</c:otherwise>
						</c:choose>
					</tr>
                    <tr height='30'>
                        <td colspan='6'>
                            <table id='menu0' style='display:none;' cellpadding='0' cellspacing='0' border='0' width='600' height='30' align=left style='font-family: 새굴림;'>
                                <tr>
                                    <td width='0'></td>
                                    <td width='600' style='text-align:left;'>
                                        |&nbsp;
                                        <a href='main'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>단지리조트 </span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='suitroom'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>스위트룸 </span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='doubleroom'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>더블룸 </span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='singleroom'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>싱글룸</span>
                                        </a>
                                        &nbsp;|
                                    </td>
                                </tr>
                            </table>
                            <table id='menu1' style='display:none;' cellpadding='0' cellspacing='0' width='600' height='30' align=left style='font-family: 새굴림;'>
                                <tr>
                                    <td width='100'></td>
                                    <td width='500' style='text-align:left;'>
                                        |&nbsp;
                                        <a href='map'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>찾아오는길</span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='transport'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>대중교통이용</span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='car'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>자가용이용</span>
                                        </a>
                                        &nbsp;|
                                    </td>
                                </tr>
                            </table>
                            <table id='menu2' style='display:none;' cellpadding='0' cellspacing='0' width='600' height='30' align=left style='font-family: 새굴림;'>
                                <tr>
                                    <td width='200'></td>
                                    <td width='400' style='text-align:left;'>
                                        |&nbsp;
                                        <a href='mountain'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>높아산</span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='beach'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>조아해수욕장</span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='hotspring'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>따끈온천</span>
                                        </a>
                                        &nbsp;|
                                    </td>
                                </tr>
                            </table>
                            <table id='menu3' style='display:none;' cellpadding='0' cellspacing='0' width='600' height='30' align=right style='font-family: 새굴림;'>
                                <tr>
                                    <td width='150'></td>
                                    <td width='450' style='text-align:center;'>
                                        |&nbsp;
                                        <a href='reservation_list'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>예약상황</span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='reservation_form'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>예약하기</span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='adm_allview'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>관리자페이지</span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='adm_logout'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>관리자로그아웃</span>
                                        </a>
                                        &nbsp;|
                                    </td>
                                </tr>
                            </table>
                            <table id='menu4' style='display:none;' cellpadding='0' cellspacing='0' width='700' height='30' align=center style='font-family: 새굴림;'>
                                <tr>
                                    <td width='350'></td>
                                    <td width='250' style='text-align:right;'>
                                        |&nbsp;
                                        <a href='news'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>리조트소식</span>
                                        </a>
                                        &nbsp;|&nbsp;
                                        <a href='review'>
                                            <span onmouseover=this.style.color='#adffeb' onmouseout=this.style.color='#1c4c87'>이용후기</span>
                                        </a>
                                        &nbsp;|
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>
            </td>
        </table>
    </center>
</body>

</html>