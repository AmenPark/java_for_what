<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookCheck</title>
</head>
<body>
	<form action="BControll" method="get">
	<input name="kw" value="${param.kw }">
	<button> 검색</button>
	</form>

	<c:forEach var="data" items="${datas}">
	<table style="width:80%; max-width:1500px;" border="2px" >
		<tr align="center"><td colspan="2"> ${data.title}</td>
		</tr>
		<tr align="center"><td colspan="2"><img alt="${data.thumbnail}" src="${data.thumbnail}"></td>
		</tr>
		<tr align="center"><td colspan="2"> ${data.contents}</td></tr>
		<tr align="center"><td> 작가</td><td>
		<c:forEach var="author" items="${data.authors }">
			 &nbsp;| &nbsp;${author } &nbsp; | &nbsp;
		</c:forEach>
		</td></tr>
		<tr align="center"><td>가격</td><td> <fmt:formatNumber type="number">${data.price }</fmt:formatNumber>\</td></tr>
		<tr align="center"><td>날짜</td><td><fmt:formatDate value="${data.datetime}" dateStyle="long"/> </td></tr>
	</table>
	</c:forEach>
</body>
</html>