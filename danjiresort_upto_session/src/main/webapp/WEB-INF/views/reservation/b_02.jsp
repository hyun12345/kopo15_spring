<!--k15전아현 / 2018.08.02.-->
<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>

<head>
    <title>*대중교통이용</title>
    
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
    
</head>

<body BACKGROUND="/danjiresort/resources/backgroundimg2.jpg">
<%@include file="top.jsp" %>

    <center>
        <table>
            <td>
                <img src="/danjiresort/resources/bus.png" width=55 height=50>
                <img src="/danjiresort/resources/metro.png" width=50 height=50>
                <span style="font-size:20pt; font-weight:bold; color:#102d51;">&nbsp;대중교통이용</span>
                </img>
                <br>
                <br>
            </td>
            <tr>
                <td>
                    <div class="map">
                        <div class="daumMap">
                            <!-- <div id="map" style="width:500px;height:100%;"></div> -->
                            <!--
                        * Daum 지도 - 약도서비스
                        * 한 페이지 내에 약도를 2개 이상 넣을 경우에는
                        * 약도의 수 만큼 소스를 새로 생성, 삽입해야 합니다.
                    -->
                            <!-- 1. 약도 노드 -->
                            <div id="daumRoughmapContainer1533122647178" class="root_daum_roughmap root_daum_roughmap_landing"></div>

                            <!-- 2. 설치 스크립트 -->
                            <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

                            <!-- 3. 실행 스크립트 -->
                            <script charset="UTF-8">
                                new daum.roughmap.Lander({
                                    "timestamp": "1533122647178",
                                    "key": "pbmr",
                                    "mapWidth": "600",
                                    "mapHeight": "400"
                                }).render();
                            </script>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
        <br>
    </center>
</body>

</html>