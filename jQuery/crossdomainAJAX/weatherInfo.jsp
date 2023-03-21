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
				url : "weather.get",
				data : {
					zone : "4471035000"
				},
				success : function(data) {
					var item = $(data).find("channel").find("item");
					var chart = new CanvasJS.Chart("chartContainer", {
						animationEnabled: true,
						theme: "light2",
						title:{
							text: $(item).find("category").text()
						},
						data: [{        
							type: "line",
					      	indexLabelFontSize: 16,
							dataPoints: function(){
									var pointinfos = [];
									var maxTemp={temp:-99999999, index:[]};
									var minTemp = {temp:99999999, index:[]};
									$(item.find("description").find("body").find("data")).each(function(i,datasec){
										var tempvar = Number($(datasec).find("temp").text());
										var timedt = Number($(datasec).find("day").text()*24+$(datasec).find("hour").text()*1);
										if(tempvar>maxTemp.temp){
											maxTemp.temp = tempvar;
											maxTemp.index= [i];
										}else if(tempvar == maxTemp.temp){
											maxTemp.index.add(i);
										}
										if(tempvar<minTemp.temp){
											minTemp.temp=tempvar;
											minTemp.index=[i];
										} else if(tempvar == minTemp.temp){
											minTemp.index.add(i);
										}
									
										pointinfos.push({y:tempvar, x:timedt})
									});
									for(var i of maxTemp.index){
										pointinfos[i].indexLabel="\u2191 highest";
									}
									for(var i of minTemp.index){
										pointinfos[i].indexLabel = "\u2193 lowest";
									}
									return pointinfos;
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