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
	request.setCharacterEncoding("EUC-KR");
	double input_value = Double.parseDouble(request.getParameter("input"));
	String[] c = request.getParameter("choice").split(",");
	double result = Double.parseDouble(c[2]) * input_value + Double.parseDouble(c[3]);
	%>
	<form>
		<table>
			<tr>
				<th align="center">변환결과</th>
			</tr>

			<tr>
				<td align="center"><font size="8"><%=String.format("%.1f", input_value)%></font><label
					class="oper<%=c%>"> <%=c[0]%></label></td>
			</tr>

			<tr>
				<td align="center">↓</td>
			</tr>

			<tr>
				<td align="center"><font size="8"><%=String.format("%.1f", result)%></font>
					<label class="oper<%=c%>"><%=c[1]%></label></td>
			</tr>
		</table>
	</form>
</body>
</html>