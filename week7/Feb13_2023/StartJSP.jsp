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
/* JSP - Java Servlet Page. HTML기반인척 작업하지만 실상은 자바로 처리해주는것. 톰캣에 넣어서 돌리는거 아님 안돌아간다.*/
/* 맨윗줄은 @으로 페이지 지시자라 하며, 서블릿화할때 참고된다. */
/* get, post 모두 이 코드가 작성된다.*/
/* 자바 코드가 쓰여지는곳은 결국 뭉쳐지고, 사이의 html이 써지는 것이므로 코드 연속성은 유지된다. */
/* <%!꼴의 느낌표는 get, post보다 바깥에 쓰인것과 같다. 메소드를 쓸 수 있다.*/
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