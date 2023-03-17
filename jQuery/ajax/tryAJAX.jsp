<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#xmlBt").click(function(){
			$.ajax({
				url : "Xml.CEOs",
				success: function(data){
					$(data).find("ceo").each(function(i,p){
						$("table").append($("<tr></tr>").append(
								$("<td></td>").text($(p).find("c_no").text()),
								$("<td></td>").text($(p).find("c_name").text()),
								$("<td></td>").text($(p).find("c_birth").text()),
								$("<td></td>").text($(p).find("c_home").text())
						));
	
					});
				}
			});
		});
		$("#JSONBt").click(function(){
			$.ajax({
				url : "JSON_CEOs",
				success: function(data){
					$.each(data.ceo, function(i,m){
						$("table").append($("<tr></tr>").append(
							$("<td></td>").text(m.c_no),		
							$("<td></td>").text(m.c_name),		
							$("<td></td>").text(m.c_birth),		
							$("<td></td>").text(m.c_home)	
						));
					});
				}
			});
		});
	});

</script>
</head>
<body>
	<h1>제대로 된 페이지</h1>
	<button id="xmlBt">Xml</button> <button id="JSONBt">JSON</button><br>
	<table>
		<tr>
		<th>번호</th>
		<th>이름</th>
		<th>생일</th>
		<th>집</th>
		</tr>
	
	</table>
</body>
</html>