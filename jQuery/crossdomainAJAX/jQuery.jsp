<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript">
	var now_url = "coffe.get";
	var now_data = {};
	function getTable(){
		$.ajax({
			url: now_url,
			data: now_data,
			success:function(coffedata){
				clearTable();
				$(coffedata).find("coffee").each(function(i,c){
				$("table").append($("<tr></tr>")
						.append($("<td></td>").append($(c).find("name").text()),
								$("<td></td>").append($(c).find("price").text()))
								);
				});
	
			}
		});
	}
	
	function clearTable(){
		var head = $("#head");
		$("table").empty();
		$("table").append(head);
	}
	
	$(function () {
		getTable();
		$("#bt1").click(function(){
			now_url="coffe.get";
			now_data={};
			getTable();
		});
		
		$("#inputBt").click(function (){
			var n =$("#name").val();
			var p = $("#price").val();
			$.ajax({
				data:{
					price:p,
					name:n
				},
				url:"jQuery/upload",
				success: function(m){
					getTable();
					alert(m);
				}
			});
			$("#price").val("");
			$("#name").val("");
		});
		$("price").keyup(function(e){
			if(e.keyCode==13){
				$("#inputBt").trigger("click");
			}
		})
		$("#name2").keyup(function(e){
			$("#searchBT").trigger("click")
		})
		$("#searchBT").click(function(){
			$.ajax({
				url:"jQuery/search",
				data:{
					name:$("#name2").val(),
				},
				success:function(coffedata){
					url="jQuery/search";
					data={
						name:$("#name2").val(),
					};
					clearTable();
					$(coffedata).find("coffee").each(function(i,c){
					$("table").append($("<tr></tr>")
							.append($("<td></td>").append($(c).find("name").text()),
									$("<td></td>").append($(c).find("price").text()))
									);
					});
		
				}
			});
		});

	});
	

</script>
</head>
<body>
	이름:
	<input id="name">
	<br> 가격:
	<input id="price">
	<br>
	<button id="inputBt">등록하기</button>

	<table>
		<tr id="head">
			<th>이름</th>
			<th>가격</th>
		</tr>
	</table>
	<button id="bt1">전체조회</button>
	<hr>
	이름: <input id="name2">
	<br>
	<button id="searchBT">검색하기</button>
</body>
</html>