<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script type="text/javascript">
	var rnum = 5;
	var pageNum = 1;
	function deleteTable() {
		var header = $("#head");
		$("table").empty();
		$("table").append(header);
	}
	function search() {
		var kw = $("#name2").val();
		$.getJSON("jQuery.JSON/getSearchedIndex?name=" + kw+"&start="+((pageNum-1)*rnum+1)+"&end="+(pageNum*rnum), function(datas) {
			$(datas.coffee).each(
					function(i, c) {
						$("table").append(
								$("<tr></tr>").append(
										$("<td></td").text(c.name),
										$("<td></td>").text(c.price)));
					})
		});
	}

	$(function() {
		pageNum=1;
		search();
		$("#name2").keyup(search);
		$("#price").keyup(function(e){
			if(e.keyCode==13){
				$("#inputBt").trigger("click");
			}
		})
	
		$("#inputBt").click(function() {
			$.ajax({
				url : "jQuery/upload",
				data : {
					name : $("#name").val(),
					price : $("#price").val()
				},
				success : function(m) {
					if (m == "success!") {
						$("#name").val("");
						$("#price").val("");
					}
					deleteTable();
					pageNum=1;
					search();
				}
			})
		})
		
		$(window).scroll(function(){
			var htmlH = $(document).height();
			var browserH = $(window).height();
			var browserTop = $(window).scrollTop();
			var browserBottom = browserTop + browserH;
			if(browserBottom <= htmlH){
				pageNum++;
				search();
			}
		});
		$("#name2").keyup(function (e){
			deleteTable();
			pageNum=1;
			search();
		})
	});
</script>
<title>JSON 테스트</title>
</head>
<body>
	이름:
	<input id="name">
	<br> 가격:
	<input id="price">
	<br>
	<button id="inputBt">등록하기</button>
	<hr>
	검색:
	<input id="name2"> 
	<table>
		<tr id="head">
			<th>이름</th>
			<th>가격</th>
		</tr>
	</table>

</body>
</html>