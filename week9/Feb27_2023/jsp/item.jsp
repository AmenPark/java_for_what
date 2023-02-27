<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function movePage(g){
	var k = g-1;
	var row = document.f.rows.value;
	location.href="ItemControll?search=${sessionScope.search}&rows="+row+"&s=${sessionScope.s}"+"&pageNum="+k;
}
</script>
</head>
<body>
	<h1> 재고현황페이지입니다. </h1>
	
	<form name="f" action="ItemControll" method="get">
		<table style="width:80%;">
			<tr><td align="right">입력:</td><td align="center"><input name="search" maxlength="12" value=${search }></td>
			<td rowspan="2"><button>검색 </button></td>
			<td><select name="rows" >
			
			<c:if test="${rows!=5}" >
			<option value="${rows}">${rows }줄</option>
			</c:if>
			<option value="5">5줄</option>
			<option value="10">10줄</option>
			<option value="20">20줄</option>
			<option value="50">50줄</option>
			</select> </td>
			<td>품목수 총 ${itemnum }개.</td>
			</tr>
			<tr><td colspan="2" align="center">
			<input type="radio" name="s" value="itemname" checked="checked"> 품목명
			<input type="radio" name="s" value="itemtype" ${itemtypechecked }> 카테고리별
			</td>
			</tr>
		</table>
	</form>
	
	<table style="width:100%; left:10%;" border="1">
	<tr>
	<th>품목명</th>
	<th>카테고리</th>
	<th>가격</th>
	<th>수량</th>
	<th>이벤트</th>
	</tr>
	<c:forEach var="it" begin="${rownum * rows}" end="${(rownum+1)*rows - 1}" items="${sessionScope.items }">
	<tr>
	<td align="center">${it.itemname }</td>
	<td align="center">${it.itemtype }</td>
	<td align="center">${it.itemprice }</td>
	<td align="center">${it.quantities }</td>
	<td align="center">${it.event }</td>
	</tr>
	</c:forEach>
	</table>
	<table>
	<tr>
	<c:forEach var="page" begin="1" end="${(sessionScope.itemnum-1)/rows + 1 }">
		<td><button onclick="movePage(${page})">${page }</button></td>
	</c:forEach>
	
	</tr>
	</table>
</body>
</html>