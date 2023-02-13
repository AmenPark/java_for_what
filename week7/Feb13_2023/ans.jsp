<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
%>
<body>
	<table>
		<tr>
		<td>
			<%=x+y %>
		</td>
		</tr>
		<tr>
		<td>
			<%=x-y %>
		</td>
		</tr>
		<tr>
		<td>
			<%=x*y %>
		</td>
		</tr>
		<tr>
		<td>
			<%=x/y %>
		</td>
		</tr>
	</table>
</body>
</html>