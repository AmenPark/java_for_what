<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/JSValcheck.js"></script>
<script type="text/javascript">
	function checkval() {
		var f = document.editf;

		if ((f.oripw.value.length < 8) ||(!(hasAllTypedChar(f.oripw, [ isDigit, isAlpha,
					getIsSpecialFunc("!@#$%_") ]) && hasOnlyTypedChar(f.oripw,
					[ isDigit, isAlpha, getIsSpecialFunc("!@#$%_") ]))) ) {
			alert("잘못된 비밀번호");
			f.oripw.focus();
			return false;
		}
		
		if (!isNull(f.newpw)) {
			if (f.newpw.value.length < 8) {
				alert("패스워드가 너무 짧아요");
				f.newpw.value = "";
				f.newpwc.value = "";
				f.newpw.focus();
				return false;
			}
			if (!(hasAllTypedChar(f.newpw, [ isDigit, isAlpha,
					getIsSpecialFunc("!@#$%_") ]) && hasOnlyTypedChar(f.newpw,
					[ isDigit, isAlpha, getIsSpecialFunc("!@#$%_") ]))) {
				alert("패스워드는 영문, 숫자, 특문 !@#$%_으로만 구성되어있고 세가지 모두 있어야 합니다.")
				f.newpw.value = "";
				f.newpwc.value = "";
				f.newpw.focus();
				return false;
			}
			if (!isEqual(f.newpw, f.newpwc)) {
				alert("패스워드 불일치");
				f.newpw.value = "";
				f.newpwc.value = "";
				f.newpw.focus();
				return false;
			}
		}

		if (!isNull(f.file)
				&& (!checkFileTypes(f.file, [ "jpg", "png", "jpeg", "gif" ]))) {
			alert("잘못된 파일");
			f.file.value = "";
			return false;
		}
		
		
		if(isNull(f.file)
				&& isNull(f.newpw)
				&& isNull(f.name)){
			return false;
		}
		alert(f.file.value.length())
		alert(f.newpw.value.length())
		alert(f.name.value.length())
		return true;

	}
	
	function checkReal(){
		var ok=confirm("탈퇴하시겠습니까?")
		if (ok){
			location.href="WithdrawalControll";
		}
	}
</script>
</head>
<body>
	<h1>계정정보</h1>
	<form name="editf" action="ProfileEditControll"  method="post" enctype="multipart/form-data"
		onsubmit="return checkval();">
		<table>
			<tr>
				<td>UserID:</td>
				<td>${sessionScope.User.userid }</td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input name="name"
					placeholder="${sessionScope.User.managerName }" maxlength="4"></td>
			</tr>
			<tr>
				<td>Area:</td>
				<td>${sessionScope.User.area }</td>
			</tr>
			<tr>
				<td>img(MAXSIZE 10MB):</td>
				<td><img alt="No IMAGE"
					src="img/profile/${sessionScope.User.userimage}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="file" name="file">
			</tr>
			<tr>
				<td>*비밀번호</td>
				<td><input type="password" maxlength="20" name="oripw">
				</td>
			</tr>
			<tr>
				<td>새 비밀번호</td>
				<td><input name="newpw" type="password"
					placeholder="숫자, 영어, 특문포함." maxlength="20"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input name="newpwc" type="password"
					placeholder="check password" maxlength="20"></td>
			</tr>
			<tr>
				<td rowspan="2" align="center"><button>수정하기</button></td>
			</tr>
		</table>
	</form>
	<h4>* 입력은 필수입니다.</h4>
	<h4><a onclick="checkReal();">계정 탈퇴</a></h4>
</body>
</html>