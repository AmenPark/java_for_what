<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cdajax</title>
<style type="text/css">
.slider {
	height:auto;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script type="text/javascript" src="resources/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript">
	var row = 5;
	$(function() {
		$("#input").keyup(function(e){
			
			if(e.keyCode==13){
				$.ajax({
					url:"https://dapi.kakao.com/v2/search/image",
					data:{
						query:$("#input").val()
					},
					"headers": {
					    "Authorization": "KakaoAK 2cc0b93ba514d9eaecf8a7ebf515f2c1",
					    "Content-Type": "application/x-www-form-urlencoded"
				 	},
				 	success:function(data){
				 		$("#imgframe").empty();
				 		var div = $('<div class="slider"></div>');
				 		$(data.documents).each(function(i,d){
				 			if(!(d.image_url.endsWith(".jpg")
				 					|| d.image_url.endsWith(".jpeg")
				 					|| d.image_url.endsWith(".png")
				 					|| d.image_url.endsWith(".psd")
				 					|| d.image_url.endsWith(".svg")
				 					|| d.image_url.endsWith(".bmp")
				 					|| d.image_url.endsWith(".gif"))){
				 				return true;
				 			}
				 			$(div).append($("<div></div>").append($("<img>").attr("src",d.image_url).attr("height",600).attr("width",800)));
				 		});
				 		$("#imgframe").append(div);
				 		$(".slider").bxSlider();
				 		
				 	}
				});
			}
		});
// 		$(".slider").bxSlider();
	});
</script>
</head>
<body>
	<input id="input">
	<table width="100%" height="50%">
	<tr>
	<td id="imgframe">
	</td>
	</tr>
	</table>
<!-- <div id="chartContainer" style="height: 370px; width: 100%;"></div> -->
<!-- <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script> -->
</body>
</html>