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
<!-- ���� ���ڸ����� ����� -->
	<h1><fmt:formatNumber>123456789</fmt:formatNumber></h1>
	<fmt:formatNumber value="${1234567 }" type="number"/>
	<br>
	<!-- �Ҽ��� ���� ǥ�� -->
	<fmt:formatNumber value="0.987223" type="percent"/>
	<hr>
	<!-- #�� ������, 0�� ������ 0 ä������.-->
	<fmt:formatNumber value="32.4" pattern="#.00"/>
	
	<!-- formatDate�� Date��ü�� ����. -->
	<!-- dateStyle-"long"�� timeStyle="short"�� ���� �������� �ð�ǥ�� ����.-->
	<!-- Ŀ���� ������ pattern="MMddE"�� ���� �߰�����. -->
	 
	<hr>
</body>
</html>