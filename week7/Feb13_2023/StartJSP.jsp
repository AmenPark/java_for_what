<%@page import="java.util.Random"%>
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
/* JSP - Java Servlet Page. HTML�����ô �۾������� �ǻ��� �ڹٷ� ó�����ִ°�. ��Ĺ�� �־ �����°� �ƴ� �ȵ��ư���.*/
/* �������� @���� ������ �����ڶ� �ϸ�, ����ȭ�Ҷ� ����ȴ�. */
/* get, post ��� �� �ڵ尡 �ۼ��ȴ�.*/
/* �ڹ� �ڵ尡 �������°��� �ᱹ ��������, ������ html�� ������ ���̹Ƿ� �ڵ� ���Ӽ��� �����ȴ�. */
/* <%!���� ����ǥ�� get, post���� �ٱ��� ���ΰͰ� ����. �޼ҵ带 �� �� �ִ�.*/
	int a=10+3;
%>
<h1><%=a %></h1>

<%! 
	public int getNo(){
		Random r = new Random();
		int x = r.nextInt(10);
		return x;
	}
%>
<%
int x=getNo();

%>
<table border="1" width="300px" height="300px">
	<tr>
	<td>
	<%
		if (x%2==0){
	%>
		<marquee><%=x %></marquee>
	<%
		}else{
	%>
		<h1><%=x %></h1>
	<%
		}
	%>
	</td>
	</tr>
</table>

</body>
</html>