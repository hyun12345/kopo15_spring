<!--k15전아현 / 2018.08.02.-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session = "true" %>
<html>

<head>
    <title>*찾아오는길</title>
    
    <link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.js"></script>
	
</head>

<body>
<%@include file="top.jsp" %>

    <center>
        <table>
            <tr>
                <td>
                    <img src="/danjiresort/resources/flag.png" width=60 height=50>
                    <span style="font-size:20pt; font-weight:bold; color:#102d51;">찾아오는길</span>
                    </img>
                    <br>
                    <br>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="map">
                        <div class="daumMap">
                            <div id="map" style="width:750px; height:500px;"></div>
                            <script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=0ed8c36320984a0265eb6ca0430b838b">
                            </script>
                            <script>
                                var mapContainer = document.getElementById('map');
                                var mapOption = {
                                    center: new daum.maps.LatLng(37.3857959, 127.1212710),
                                    level: 3
                                };
                                var map = new daum.maps.Map(mapContainer, mapOption);
                                var markerPosition = new daum.maps.LatLng(37.3857959, 127.1212710);
                                var marker = new daum.maps.Marker({
                                    position: markerPosition
                                });
                                marker.setMap(map);
                            </script>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
        <br>
        <h2>단지리조트는 위도(37.3857959) 경도(127.1212710)에 위치해있습니다.</h2>
    </center>
</body>

</html>