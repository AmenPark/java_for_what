// 이런 class를 작성 시에는 첫 문자를 대문자로 하는것이 좋다.
public class Human {
	// 객체 속성
	// member variable, attribute, field.
	String name;
	int age;
	
	// 객체 행동. 프로그램에 필요한 기능.
	// method.
	public Human(String n, int m) {
		name = n;
		age = m;
	}
	
	// python의 self와 같이 java는 this를 사용한다. 다만 버전업에 따라 this는 생략이 가능하다. 컴파일러가 알아서 해줌. 동명의 로컬변수 존재시 해당 로컬변수 우선.
	public void say(String info) {
		System.out.println(info);
	}

}
