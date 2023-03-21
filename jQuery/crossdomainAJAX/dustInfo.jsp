<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cdajax</title>
<script type="text/javascript" src="resources/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#bt1").click(function(){
			$.ajax({
				url : "http://openapi.seoul.go.kr:8088/{APPKEY}/xml/RealtimeCityAir/1/25/",
				success : function(data) {
					var item = $(data).find("row");
					var chart = new CanvasJS.Chart("chartContainer", {
						animationEnabled: true,
						theme: "dark1",
						title:{
							text: "전국 미세먼지 현황"
						},
						axisY: {
							title: "먼지량",
							valueFormatString:"#ppm"
						},
						data: [{        
							type: "stackedColumn",  
							showInLegend: true, 
							color: "#696661",
							name: "미세먼지",
							dataPoints: function(){
								var data = [];
								$(item).each(function(i,row){
									data[i]={y:$(row).find("PM10").text()*1, label:$(row).find("MSRSTE_NM").text()};
								});
								return data;
							}()
						},
						{
							type: "stackedColumn",  
							showInLegend: true, 
							color: "#EDCA93",
							name: "초미세먼지",
							dataPoints: function(){
								var data = [];
								$(item).each(function(i,row){
									data[i] = {y:$(row).find("PM25").text()*1, label:$(row).find("MSRSTE_NM").text()};
								});
								return data;
							}()
						}]
					});
					chart.render();
				}
			})
		});
	})
</script>
</head>
<body>
	<button id="bt1">통신하기</button>
	<table id="tb" border="1">
	
	</table>
	
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>