<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table >
	<tr><td align="center">
	<img alt="${sessionScope.User.userid }" src="img/profile/${sessionScope.User.userimage }" height="40">
	</td>
	<td>
	${sessionScope.User.managerName }������ �α��� 
	<form action="LogoutControll" method="post">
	<button>�α׾ƿ�</button>
	</form>
	</td>
	<td>
	<form action=ProfileControll>
	<button>��������</button>
	</form>
	</td>
	</tr>
	</table>
</body>
</html>