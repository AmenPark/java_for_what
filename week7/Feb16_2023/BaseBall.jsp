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
<title>���ھ߱�</title>
</head>
<body>
	<form name="f" action="BBC" method="get" onsubmit="return check();">
	<table>
		<tr>
			<th colspan="2"> ���ھ߱�
			</th>
		</tr>
		<tr><td>�ְ���:</td><td>${data.best_score} </td></tr>
		<tr>
			<td colspan="1"> �Է�: <input name="input" maxlength="3"></td>
			<td><button>������</button></td>
		</tr>
		<tr>
			<td> �ϼ�: </td>
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