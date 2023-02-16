<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/output.css" type="text/css">
<script type="text/javascript" src="js/validations.js"></script>
<script type="text/javascript">
function check(){
	var input = document.f.input
	if(!lengthis(input,3)){
		input.focus();
		return false;
	}
	if(!isAllNum(input)){
		input.value="";
		input.focus();
		return false;
	}
	if(hasSameNum(input)){
		input.value=""
		input.focus();
		return false;
	}
	return true;
}

</script>
<title>숫자야구</title>
</head>
<body>
	<form name="f" action="BBC" method="get" onsubmit="return check();">
	<table>
		<tr>
			<th colspan="2"> 숫자야구
			</th>
		</tr>
		<tr><td>최고점:</td><td>${data.best_score} </td></tr>
		<tr>
			<td colspan="1"> 입력: <input name="input" maxlength="3"></td>
			<td><button>보내기</button></td>
		</tr>
		<tr>
			<td> 턴수: </td>
			<td> ${data.turn}</td>
		</tr>
		<tr>
		<td>
			${data.log}
		</td>
		</tr>
	</table>
	</form>
</body>
</html>