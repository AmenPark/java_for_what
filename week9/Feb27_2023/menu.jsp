<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ ���� ������</title>
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
								������ ���� ������</a></td>
						<td ><jsp:include page="${log }" /></td>
					</tr>
				</table>
		</td>
		</tr>
		<tr>
			<td align="center">
				<table class="insidemenu" border="1" style="width:100%;">
					<tr>
						<td align="center"><a href="ItemControll">���</a></td>
						<td align="center"><a href="OrderCheckControll">����Ȯ��</a></td>
						<td align="center"><a href="TryOrderControll">�����ϱ�</a></td>
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