<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cdajax</title>
<style type="text/css">
.slider {
	height: auto;
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script type="text/javascript" src="resources/jquery.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey={APPKEY}"></script>

<script type="text/javascript">
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"
	var imageSize = new kakao.maps.Size(24, 35); 
	var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	$(function() {
		navigator.geolocation.getCurrentPosition(function(loc) {
			lat = loc.coords.latitude;
			lnt = loc.coords.longitude;
			var position = new kakao.maps.LatLng(lat, lnt);
			console.log({lat:lat, lnt:lnt});

			var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
			var options = { //지도를 생성할 때 필요한 기본 옵션
				center : position, //지도의 중심좌표.
				level : 3
			//지도의 레벨(확대, 축소 정도)
			};
			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

			var roadviewContainer = document.getElementById('roadview'); //로드뷰를 표시할 div
			var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
			var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체
			
			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
			    position: position,
			    image : markerImage
			});

			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);

			// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
			  
			

			// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
			roadviewClient.getNearestPanoId(position, 50, function(panoId) {
				roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
			});
// 			kakao.maps.event.addListener(roadview, 'panoid_changed',
// 					function() {
// 						var lat = roadview.getPosition();
// 						position = new kakao.maps.LatLng(lat.Ma, lat.La);
// 						// 지도 중심을 부드럽게 이동시킵니다
// 						// 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
// 						map.setCenter(position);
// 						marker.setMap(null);
// 						marker=new kakao.maps.Marker({
// 						    position: position
// 						});
// 						marker.setMap(map);
// 					});
			var markers=[];
			$("#search").keyup(function(e){
				if(e.keyCode==13){
					const settings = {
							  "async": true,
							  "crossDomain": true,
							  "url": "https://dapi.kakao.com/v2/local/search/keyword.json?y=37.514322572335935&x=127.06283102249932&radius=20000",
							  "method": "GET",
							  "headers": {
							    "Authorization": "KakaoAK 9656be7a6c4498c7ebceae9dc35b5d5c",
							    "Content-Type": "application/x-www-form-urlencoded"
							  },
							  "data": {
							    "query": $("#search").val(),
							    x:lnt,
							    y:lat,
							    radius:20000,
							  }
							};

					$.ajax(settings).done(function (response) {
						$(markers).each(function(i,obj){
							obj.setMap(null);
						});
						markers=[];
						console.log(response);
						$("#infos").empty();
						var table = $('<table border="1"></table>')
						$(response.documents).each(function(i,obj){
							var tr = $("<tr></tr>");
							tr.append($("<td></td>").text(obj.place_name));
							tr.append($("<td></td>").text(obj.address_name));
							tr.append($("<td></td>").text(obj.road_address_name));
							tr.append($("<td></td>").append($("<button></button>").text("이동하기").click(function(){
								var moveLatLon = new kakao.maps.LatLng(obj.y, obj.x);
							    map.panTo(moveLatLon);
							    roadviewClient.getNearestPanoId(moveLatLon, 50, function(panoId) {
								roadview.setPanoId(panoId, moveLatLon); //panoId와 중심좌표를 통해 로드뷰 실행
								});
							})));
							var tempMarker= new kakao.maps.Marker({
							    position: new kakao.maps.LatLng(obj.y, obj.x)
							});
							tempMarker.setMap(map);
							markers.push(tempMarker);
							table.append(tr);
						})
						console.log(markers);
						$("#infos").append(table);
					  	console.log(response);
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<input id="search">
	<div id="map" style="width: 400px; height: 300px;"></div>
	<div id="roadview" style="width: 400; height: 300px;"></div>
	<br>
	<div id="infos">
	
	</div>
</body>
</html>