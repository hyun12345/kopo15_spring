<!--k15전아현 / 2018.08.02.-->
<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>

<head>
    <title>*자가용이용</title>
    
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

<body>
<!-- <div style="background-image: url('resources/backgroundimg2.jpg'); background-size: cover; height: 100%;"> -->

<%@include file="top.jsp" %>
    <center>
        <table>
        <tr>
            <td>
                <img src="/danjiresort/resources/car.png" width=55 height=50>
                <span style="font-size:20pt; font-weight:bold; color:#102d51;">&nbsp;자가용이용</span>
                <br>
                <br>
            </td>
       </tr>
            <tr>
                <td>
                    <div id="map" style="width:750px; height:500px;"></div>
                    <p>
                        <br>
                        <button type="button" class="mini ui teal button" onclick="setOverlayMapTypeId('traffic')">교통정보
                        </button>
                        <button type="button" class="mini ui teal button" onclick="setOverlayMapTypeId('roadview')">로드뷰 도로정보
                        </button>
                    </p>
                    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c64306740e075bc901d6c821527db378"></script>
                    <script>
                        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                            mapOption = {
                                center: new daum.maps.LatLng(37.3857959, 127.1212710), // 지도의 중심좌표
                                level: 5 // 지도의 확대 레벨
                            };

                        var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

                        // 마커가 표시될 위치입니다 
                        var markerPosition = new daum.maps.LatLng(37.3857959, 127.1212710);

                        // 마커를 생성합니다
                        var marker = new daum.maps.Marker({
                            position: markerPosition,
                            clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
                        });

                        // 마커가 지도 위에 표시되도록 설정합니다
                        marker.setMap(map);
                        
                        var iwContent = '<div style="padding:5px;">Danji Resort <br><a href="http://map.daum.net/link/map/Danji Resort,37.3857959,127.1212710" style="color:skyblue" target="_blank">*큰지도</a> <a href="http://map.daum.net/link/to/Danji Resort,37.3857959,127.1212710" style="color:skyblue" target="_blank">*길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                        	iwPosition = new daum.maps.LatLng(37.3857959, 127.1212710); //인포윈도우 표시 위치입니다
                        	iwRemoveable = true;  // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
						
                     	// 인포윈도우를 생성합니다
                        var infowindow = new daum.maps.InfoWindow({
                        	map : map,
                            position : iwPosition, 
                            content : iwContent,
                            removable : iwRemoveable
                        });
                        	
                     	// 마커에 클릭이벤트를 등록합니다
                        daum.maps.event.addListener(marker, 'click', function() {
                              // 마커 위에 인포윈도우를 표시합니다
                              infowindow.open(map, marker);  
                        });
                        
                        // 지도에 추가된 지도타입정보를 가지고 있을 변수입니다
                        var currentTypeId;

                        // 버튼이 클릭되면 호출되는 함수입니다
                        function setOverlayMapTypeId(maptype) {
                            var changeMaptype;

                            // maptype에 따라 지도에 추가할 지도타입을 결정합니다
                            if (maptype === 'traffic') {

                                // 교통정보 지도타입
                                changeMaptype = daum.maps.MapTypeId.TRAFFIC;

                            } else if (maptype === 'roadview') {

                                // 로드뷰 도로정보 지도타입
                                changeMaptype = daum.maps.MapTypeId.ROADVIEW;

                            }

                            // 이미 등록된 지도 타입이 있으면 제거합니다
                            if (currentTypeId) {
                                map.removeOverlayMapTypeId(currentTypeId);
                            }

                            // maptype에 해당하는 지도타입을 지도에 추가합니다
                            map.addOverlayMapTypeId(changeMaptype);

                            // 지도에 추가된 타입정보를 갱신합니다
                            currentTypeId = changeMaptype;
                        }
                    </script>
                </td>
            </tr>
        </table>
        <!-- <span style "font-size:12; font-weight:bold;"></span> -->
        <br>
        <h2>
            교통의 혼잡함에 유의하여 주십시오.
        </h2>
    </center>
<!-- </div> -->
</body>

</html>