# 편의점 미니 팀프로젝트
## 기본세팅이 좀 헷갈린다.
## 세팅할점
- mapper.xml은 source에, interface는 java에 들어간다.
- mapper 파일명은 servlet-context의 xml에 입력된다. sqlsessionfactory 작성시 list에 하나씩.
- mapper 파일은 interface와 1:1 연동이며, mapper의 namespace가 패키지명을 포함한 인터페이스 파일명이 된다.
- 인터페이스의 추상메소드들은 매퍼에서 메소드명이 id로 주어진다.
- 인터페이스 작성시 리턴타입은 쿼리문 종류에 따라 달라진다.
