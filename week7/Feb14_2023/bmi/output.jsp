<%@page import="com.PAM.Feb14.model2VMC.VOBMI"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>
<%
	VOBMI data = (VOBMI)request.getAttribute("info");
%>
<body>
	<table>
	<tr>
	<th colspan="2" align="center"> ���</th>
	</tr>
	<tr><td colspan="2" align="center" width="300px">
	<img src=<%=data.getFilePath() %>></td></tr>
	<tr><td align="center"> �̸�</td>
	<td align="center"> <%=data.getName() %> </td>
	</tr>
	
	<tr><td align="center">Ű</td>
	<td align="center"><%=data.getHeight() %> cm</td>
	</tr>
	
	<tr><td align="center">������</td>
	<td align="center"><%=data.getWeight() %> kg</td>
	</tr>
	
	<tr><td align="center">ǥ��ü��</td>
	<td align="center"><%=data.getStdweight() %> kg</td>
	</tr>
	
	<tr><td align="center">�񸸵�</td>
	<td align="center"><%=data.getBmi() %> %</td>
	</tr>
	
	<tr><td align="center" colspan="2"> <%=data.getResult() %></td></tr>
	</table>
</body>
</html>