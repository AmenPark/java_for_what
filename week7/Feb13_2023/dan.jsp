<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	int i= Integer.parseInt(request.getParameter("x"));
%>
	<table>
		<tr><th>
		<%=i %>단
		</th></tr>
		<%for(int j=1;j<10;j++){ %>
		<tr>
		<td>
			<%=String.format("%d * %d = %d", i,j,i*j) %>
		</td>
		</tr>
		<%} %>

	</table>
</body>
</html>