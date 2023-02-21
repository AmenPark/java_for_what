# 쿠키세션. 이용한 로그인 기본구현.
# sql 한 스푼

##### 대충 메모
request parameter
front에서 만들어진 값. get은 주소에서, post는 내부에서.
get은 톰캣 server.xml에서 한글처리를 해줌.
post는 req.setCharacterEncoding("euc-kr")로 한글처리.
EL에서 읽기: ${param.ParameterName}

request parameter. Attribute.
back-end에서 만들어진 값. Object가 다 들어간다. 기본형은 사실 바뀌어서 들어가는것임.
Java에서 읽기 : request.getAttribute("Attribute_Name");
EL에서 읽기 : ${AttributeName}
getAttribute는 object를 받아서 형변환해서 쓰는것이다.

redirect - 그냥 이동하도록 안내하는것. "xxx로 전화하세요~" 하고 직접 전화하는 방식. 주소가 바뀐다.
forward - 요청 정보까지 넘겨서 알아서 연결해주는것. "연결해드릴게요~" 하고 연결해줌. 주소가 바뀌지 않음.

session, cookie
session - back-end에서 만들어진 값.
 	Object.
	Session 소속. 서버와 사용자의 연결상태에 대한 값이다.
java에서는 request.getSession()으로 구한 HttpSession으로 getAttribute("NAME")꼴로 얻어서 사용한다.
el에서는 ${sessionScope.NAME} 꼴로 사용한다.
hs.setMaxInactiveInterval(num) -> 세션유지시간 세팅. 놀랍게도 뒤로가기, 앞으로가기 등도 시간내로 쳐준다.'

cookie - back-end에서 만들어진 값.
	String만 가능.
	사용자 pc에 파일로 저장됨.
	request.getCookies()로 쿠키들을 얻을 수 있음.
쿠키를 쓰기 위해서는 response가 필요하다.
	response.addCookie(cookie)로 추가.
Cookie c = new Cookie(name, info); 꼴로 쿠키를 만들 수 있음. setAttribute 느낌.
EL - ${cookie.쿠키명.value} 꼴로 사용가능.
cookie에 대해서 .getName으로 이름을 찾고, getValue로 value를 찾는다.
c.setMaxAge(10) <- 쿠키 유효시간 설정. 무조건 해당 시간동안 살아있다.
