<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 홈입니다 </h1>
<a href="jQuery">j쿼리테스트</a><br>
<a href="jQuery.JSON">JSON테스트</a><br>
<table>
	<tr>
	<th> 이름</th><th> 가격 </th>
	</tr>
	<c:forEach var="d" items="${data }">
	<tr>
	<td>${d.name }</td><td>${d.price }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>