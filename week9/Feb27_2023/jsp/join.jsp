<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/JSValcheck.js"></script>
<script type="text/javascript">

	function valcheck(){
		f = document.signin;
		if(isNull(f.id)){
			alert("id ä�켼��");
			f.id.focus();
			return false;
		}
		if(f.pw.value.length < 8){
			alert("�н����尡 �ʹ� ª�ƿ�");
			f.pw.value="";
			f.pwc.value="";
			f.pw.focus();
			return false;
		}
		if(!(hasAllTypedChar(f.pw, [isDigit, isAlpha, getIsSpecialFunc("!@#$%_")])
				&& hasOnlyTypedChar(f.pw, [isDigit, isAlpha, getIsSpecialFunc("!@#$%_")]))){
			alert("�н������ ����, ����, Ư�� !@#$%_���θ� �����Ǿ��ְ� ������ ��� �־�� �մϴ�.")
			f.pw.value="";
			f.pwc.value="";
			f.pw.focus();
			return false;
		}
		if(!isEqual(f.pw,f.pwc)){
			alert("�н����� ����ġ");
			f.pw.value="";
			f.pwc.value="";
			f.pw.focus();
			return false;
		}
		if(isNull(f.name)){
			alert("�̸� �ʼ�");
			f.name.focus();
			return false;
		}
		if(hasAllTypedChar(f.name, [isDigit])||
				hasAllTypedChar(f.name, [getIsSpecialFunc("!@#$%^&*()_-=+|\\{}[]<>,./?;\'\":;`~")])){
			alert("�߸��� �̸�");
			f.name.value="";
			f.name.focus();
			return false;
		}
		if(!isNull(f.file) &&
				(!checkFileTypes(f.file, ["jpg", "png", "jpeg", "gif"]))){
			alert("�߸��� ����");
			f.file.value="";
			return false;
		}
		return true;		
		
	}
</script>
</head>
<body>
<h1> ȸ������ </h1>
	<table style="width:80%; align:center;"><tr><td align="center">
	<form name="signin" action="JoinControll" method = "post" enctype="multipart/form-data" onsubmit="return valcheck();" >
	*<input name="id" placeholder="YourID" maxlength="20"><br>
	*<input name="pw" type="password" placeholder="Yourpw" maxlength="20"><br>
	*<input name="pwc" type="password" placeholder="pwCheck" maxlength="20"><br>
	*<input name="name" placeholder="Convinient Manager Name" maxlength="4"><br>
	�̹��� ���<input name="file" type="file"><br>
	*<select name="area">
		<option value="����" selected="selected" >����Ư����</option>
		<option value="�λ�">�λ걤����</option>
		<option value="�뱸">�뱸������</option>
		<option value="��õ">��õ������</option>
		<option value="����">���ֱ�����</option>
		<option value="����">����������</option>
		<option value="���">��걤����</option>
		<option value="����">����Ư����ġ��</option>
		<option value="���">��⵵</option>
		<option value="����">������</option>
		<option value="���">��û�ϵ�</option>
		<option value="�泲">��û����</option>
		<option value="����">����ϵ�</option>
		<option value="����">���󳲵�</option>
		<option value="���">���ϵ�</option>
		<option value="�泲">��󳲵�</option>
		<option value="����">����Ư����ġ��</option>
	</select><br>
	<button>����</button>
	</form>
	</td></tr></table>
	*�� �ʼ��Դϴ�.<br>
	
	
</body>
</html>