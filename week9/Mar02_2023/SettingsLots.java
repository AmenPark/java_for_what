package com.PAM.settings;


// mybatis. Maven.
// jar 파일 관리하기? 
// kmxl.jar을 사용해서 썼는데, 여긴 있을리가 없음.
// 빌드패스에 추가하기, web-inf/lib에 추가하기, ... 다 수동.
// 설정에 텍스트 추가해서 자동관리하는게 Maven에 지원됨.
// maven은 pom.xml로 제어. xml로 다운받을 경로를 저장해준다.
// dependencies를 프로젝트 안쪽, 한 단계 바로 안쪽으로만 넣어서 maven의 xml을 복붙해주면 세팅을 해줌.
// 로컬에 저장 후 세팅해줌. C-user/계정명/.m2/repository 내부에 존재.
// 간혹 다운받다가 문제가 생길 때가 있음. 
// Maven 사용시 수동과 병행이 불가능. 즉, 내가만든게 문제.
// import-maven:install or deploy on ~~~. -> artifactual file에 jar 추가. groupid, artifactId, version을 통해서 xml에 추가 가능.
// 또는 서버로 운영되는 경우 repository를 xml에 넣어서 사용 가능. 태그위치는 dependencies와 repositories가 병렬적.
// repo에는 maven metadata가 필요하기 때문에 url로 다 되는게 아니다.

//mybatis - sql을 분리. db서버 연결정보나 sql 쿼리문을 코드와 완벽하게 분리.
//유지보수 유리, 보안 유리 등 여러 이점 존재.

public class SettingsLots {
	public static void main(String[] args) {
		
	}
}
