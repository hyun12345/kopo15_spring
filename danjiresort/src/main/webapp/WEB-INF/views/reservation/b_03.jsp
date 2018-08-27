<!--k15전아현 / 2018.08.02.-->
<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>

<head>
    <title>*자가용이용</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>

<body BACKGROUND="/danjiresort/resources/backgroundimg2.jpg">
<%@include file="top.jsp" %>

    <center>
        <table>
            <td>
                <img src="/danjiresort/resources/car.png" width=55 height=50>
                <span style="font-size:20pt; font-weight:bold; color:#102d51;">&nbsp;자가용이용</span>
                </img>
                <br>
                <br>
            </td>
            <tr>
                <td>
                    <div id="map" style="width:750px; height:500px;"></div>
                    <p>
                        <br>
                        <button type="button" class="btn btn-info btn-sm text-light" onclick="setOverlayMapTypeId('traffic')">교통정보
                        </button>
                        <button type="button" class="btn btn-info btn-sm text-light" onclick="setOverlayMapTypeId('roadview')">로드뷰 도로정보
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
                            position: markerPosition
                        });

                        // 마커가 지도 위에 표시되도록 설정합니다
                        marker.setMap(map);

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
        <h4>
            교통의 혼잡함에 유의하여 주십시오.
        </h4>
    </center>
</body>

</html>