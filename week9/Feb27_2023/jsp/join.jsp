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
			alert("id 채우세요");
			f.id.focus();
			return false;
		}
		if(f.pw.value.length < 8){
			alert("패스워드가 너무 짧아요");
			f.pw.value="";
			f.pwc.value="";
			f.pw.focus();
			return false;
		}
		if(!(hasAllTypedChar(f.pw, [isDigit, isAlpha, getIsSpecialFunc("!@#$%_")])
				&& hasOnlyTypedChar(f.pw, [isDigit, isAlpha, getIsSpecialFunc("!@#$%_")]))){
			alert("패스워드는 영문, 숫자, 특문 !@#$%_으로만 구성되어있고 세가지 모두 있어야 합니다.")
			f.pw.value="";
			f.pwc.value="";
			f.pw.focus();
			return false;
		}
		if(!isEqual(f.pw,f.pwc)){
			alert("패스워드 불일치");
			f.pw.value="";
			f.pwc.value="";
			f.pw.focus();
			return false;
		}
		if(isNull(f.name)){
			alert("이름 필수");
			f.name.focus();
			return false;
		}
		if(hasAllTypedChar(f.name, [isDigit])||
				hasAllTypedChar(f.name, [getIsSpecialFunc("!@#$%^&*()_-=+|\\{}[]<>,./?;\'\":;`~")])){
			alert("잘못된 이름");
			f.name.value="";
			f.name.focus();
			return false;
		}
		if(!isNull(f.file) &&
				(!checkFileTypes(f.file, ["jpg", "png", "jpeg", "gif"]))){
			alert("잘못된 파일");
			f.file.value="";
			return false;
		}
		return true;		
		
	}
</script>
</head>
<body>
<h1> 회원가입 </h1>
	<table style="width:80%; align:center;"><tr><td align="center">
	<form name="signin" action="JoinControll" method = "post" enctype="multipart/form-data" onsubmit="return valcheck();" >
	*<input name="id" placeholder="YourID" maxlength="20"><br>
	*<input name="pw" type="password" placeholder="Yourpw" maxlength="20"><br>
	*<input name="pwc" type="password" placeholder="pwCheck" maxlength="20"><br>
	*<input name="name" placeholder="Convinient Manager Name" maxlength="4"><br>
	이미지 등록<input name="file" type="file"><br>
	*<select name="area">
		<option value="서울" selected="selected" >서울특별시</option>
		<option value="부산">부산광역시</option>
		<option value="대구">대구광역시</option>
		<option value="인천">인천광역시</option>
		<option value="광주">광주광역시</option>
		<option value="대전">대전광역시</option>
		<option value="울산">울산광역시</option>
		<option value="세종">세종특별자치시</option>
		<option value="경기">경기도</option>
		<option value="강원">강원도</option>
		<option value="충북">충청북도</option>
		<option value="충남">충청남도</option>
		<option value="전북">전라북도</option>
		<option value="전남">전라남도</option>
		<option value="경북">경상북도</option>
		<option value="경남">경상남도</option>
		<option value="제주">제주특별자치도</option>
	</select><br>
	<button>가입</button>
	</form>
	</td></tr></table>
	*은 필수입니다.<br>
	
	
</body>
</html>