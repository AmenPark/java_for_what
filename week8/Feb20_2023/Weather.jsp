<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��������</title>
</head>
<body>
<h1 align="center">������ ���� �˷��帳�ϴ�.</h1>

	<c:forEach var="wdto" items="${infos}">
	<table style="float:left;" align="center">
		<tr>
		<td>day</td>
		<td>${wdto.day}</td>
		</tr>
		<tr><td>hour</td>
		<td>${wdto.hour }</td>
		</tr>
		<tr><td>temperature</td>
		<td>${wdto.temp }</td>
		</tr>
		<tr><td>weather</td>
		<td><img alt="${wdto.wfKor}" src="${wdto.wfEn}"></td>
		</tr>
	</table>
	</c:forEach>
</body>
</html>