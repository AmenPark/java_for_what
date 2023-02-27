<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>나만의 작은 편의점</title>
<script type="text/javascript">
	function makealert() {
		if ("${message}".length > 0) {
			alert("${message}");
		}
	}
</script>


<link rel="stylesheet" type="text/css" href="css/menubar.css">
<style></style>
</head>
<body onload="makealert();">
	<table id="menu">
		<tr>
			<td align="center">
				<table class="insidemenu" border="1"  style="width:100%;">
					<tr>
						<td align="center"><a href="HomeControll">
								나만의 작은 편의점</a></td>
						<td ><jsp:include page="${log }" /></td>
					</tr>
				</table>
		</td>
		</tr>
		<tr>
			<td align="center">
				<table class="insidemenu" border="1" style="width:100%;">
					<tr>
						<td align="center"><a href="ItemControll">재고</a></td>
						<td align="center"><a href="OrderCheckControll">수령확인</a></td>
						<td align="center"><a href="TryOrderControll">발주하기</a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="${contents }" />


</body>
</html>