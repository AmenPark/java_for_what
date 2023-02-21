<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>과자입력하기</title>
<script type="text/javascript">
	function snackValidation(){
		var f = document.snack_form;
		
		if(f.input.value==""){
			alert("상품명 필수!");
			f.input.focus();
			return false;
		}
		if(f.price.value==""){
			alert("가격도 필수!");
			return false;
		}
		if(isNaN(f.price.value)){
			alert("not a number!");
			f.price.focus();
			return false;
		}
		if(f.price.value.indexOf('.')!=-1){
			alert('not a decimal number!');
			f.price.focus();
			return false;
		}
		if(f.price.value<0){
			alert('not less then zero!');
			f.price.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form action="" method="get" name="snack_form" onsubmit="return snackValidation();">
	과자명:<input name="input" maxlength=10><br>
	가격:<input name="price" maxlength=8><br>
	<button>등록하기</button>
</form>
<c:forEach var="data" items="${snacks }">
	<table border="1" style="float:left;">
	<tr><td>${data.name }</td></tr>
	<tr><td>${data.price }</td></tr>
	</table>
</c:forEach>

</body>
</html>