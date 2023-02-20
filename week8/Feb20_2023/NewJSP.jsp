<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	
%>
<!-- 숫자 세자리마다 점찍기 -->
	<h1><fmt:formatNumber>123456789</fmt:formatNumber></h1>
	<fmt:formatNumber value="${1234567 }" type="number"/>
	<br>
	<!-- 소숫점 떼고 표시 -->
	<fmt:formatNumber value="0.987223" type="percent"/>
	<hr>
	<!-- #은 있으면, 0은 무조건 0 채워서라도.-->
	<fmt:formatNumber value="32.4" pattern="#.00"/>
	
	<!-- formatDate는 Date객체만 가능. -->
	<!-- dateStyle-"long"과 timeStyle="short"를 통해 어지간한 시간표현 가능.-->
	<!-- 커스텀 패턴은 pattern="MMddE"와 같이 추가가능. -->
	 
	<hr>
</body>
</html>