<%@page import="com.PAM.Feb14.VMCModel.UCResult"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/styleCSS.css" type="text/css">
<title>단위변환</title>
</head>
<body>
	<%
	UCResult ucr = (UCResult) request.getAttribute("result");
	%>
	<form>
		<table>
			<tr>
				<th align="center">변환결과</th>
			</tr>

			<tr>
				<td align="center"><font size="8"><%=ucr.getWhat()%></font><label
					class="oper<%=ucr.getC()%>"> <%=ucr.getUnit1()%></label></td>
			</tr>

			<tr>
				<td align="center">↓</td>
			</tr>

			<tr>
				<td align="center"><font size="8"><%=ucr.getResult()%></font>
					<label class="oper<%=ucr.getC()%>"><%=ucr.getUnit2()%></label></td>
			</tr>
		</table>
	</form>
</body>
</html>