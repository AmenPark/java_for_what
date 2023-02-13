<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function gogo(){
		location.href="second.jsp";
	}
</script>
</head>
<body>
<%
	//request. 
%>
	<h1>first</h1>
	<a href="second.jsp">second로1</a>
	
	<div ondblclick="gogo();">second로2</div>
	
	<form action="second.jsp" method="post">
		a: <input name="q"><br>
		b: <input name="w"><br>
		<button>second로3</button>
	</form>
</body>
</html>