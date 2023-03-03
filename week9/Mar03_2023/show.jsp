<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<c:forEach var="snack" items="${snacks }">
	<tr>
	<td>${snack.name }</td><td>${snack.price }</td><td><fmt:formatDate value="${snack.exp }"/></td><td>${snack.exp }</td><td>3</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>