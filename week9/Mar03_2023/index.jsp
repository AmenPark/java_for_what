<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="homeCon">입력하기</a> <a href="ShowControll">조회하기 </a>
	<jsp:include page="${contentpage }"></jsp:include>
	<br><br>
	${ct }
</body>
</html>