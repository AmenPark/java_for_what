<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>계정정보</h1>
	<table>
	<tr><td>UserID:</td>
	<td>${sessionScope.User.userid }</td>
	</tr>
	<tr><td>Name:</td>
	<td>${sessionScope.User.managerName }</td>
	</tr>
	<tr><td>Area:</td>
	<td>${sessionScope.User.area }</td>
	</tr>
	<tr><td>img(MAXSIZE 10MB):</td>
	<td><img alt="No IMAGE" src="img/profile/${sessionScope.User.userimage}"> </td>
	</tr>
	<tr><td colspan="2"><form name="f" action="ProfileEditControll" method="get"><button>정보 수정하기</button></form></td></tr>
	</table>
</body>
</html>