<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/JSValcheck.js"></script>
<script type="text/javascript">
function checkvalidation(){
	if(isNull(f.id)||isNull(f.pw)){
		return false;
	}
}
</script>
</head>
<body>
	<table>
	<tr>
	<td> <form action="JoinControll"> <button >회원가입</button></form> </td>
	<td><form action="HomeControll" method="post" name="f" onsubmit="return checkvalidation();">
	<table>
	<tr><td>id:</td>
	<td> <input name="id"></td>
	</tr>
	<tr><td>pw:</td>
	<td><input name="pw" type="password"></td>
	</tr>
	<tr><td colspan="2" align="center">	<button>로그인</button> </td></tr>
	</table>
	</form></td>
	</tr>
	</table>	
</body>
</html>