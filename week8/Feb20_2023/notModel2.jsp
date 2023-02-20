<%@page import="oracle.jdbc.driver.OracleDriver"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	/* oracleDriver 자동완성시 위의 import oracledriver이 나온다. 거기서 class forname으로 선언해줘야함. */
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = null;
	try{
		String url="jdbc:oracle:thin:@192.168.0.152:1521:xe";
		conn=DriverManager.getConnection(url, "me", "369");
		
	%>
		<h1>connected</h1>
	<%
		
	}	catch(Exception e){
	} finally{
		try{
		conn.close();
		} catch(Exception e){
		}
	}

%>

</body>
</html>