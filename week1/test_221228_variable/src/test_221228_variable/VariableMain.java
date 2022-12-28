package test_221228_variable;
/*
 * CPU - 계산담당. 속도에 영향을 줌.
 * CPU가 멀티코어다 - 코어 숫자만큼 동시연산가능.
 * RAM - 메모리. 빠르게 CPU에 올려줄 수 있는 작은 양이다.
 * SSD/HDD - 데이터저장소. 느리게 데이터를 CPU로 올릴 수 있으며 많은 양 저장 가능.
 * GPU - 그래픽 연산자. 간단한 연산 정도만 할 수 있음.
*/

//변수명은 _, $ 두가지 특문을 허용한다.
//변수명은 소문자 시작을 추구. 클래스명이 대문자 시작인 것과 main포함시 Main붙이는 등, 한눈에 비교 가능하게.

// long과 float를 선언할때 long은 int범위 넘어가면 211111111111L꼴로 L(대소관계없음)을 붙여준다.
// 비슷하게 float는 소숫점 표현할때 1.5f 와 같이 f를 붙여 선언해야한다.
// 그냥 13.13하면 double로 취급이다.
// text/code - data - heap - stack
// text/code - 실행 코드(텍스트)가 저장됨. 기계어로 저장. 명령어를 하나씩 cpu가 여기서 가져감.
// data - 전역, 정적변수, 문자열 상수 등이 저장. BSS/GVAR의 영역. BSS는 RAM에 초기화안된 데이터 저장. GVAR은 초기화된걸 ROM에 저장.
// stack - 프로그램이 자동적으로 사용. 지역변수, 매개변수 등이 저장. 함수호출시 스택할당, 함수끝시 소멸. 후입선출로 나중에 들어온게 먼저 호출. 그래서 거꾸로구나
// heap - 사용자가 직접 관리하는 영역. 정방향이라 선입선출. 런타임시 크기가 결정됨.  <- garbage collection이 관리해줌.
//alt 상하는 줄이동 편집. 좌우는 이동. 끝에 도달하면 다음 탭으로 이동한다.
public class VariableMain {
	public static void main(String[] args) {
		long l = 21111111111L;
		System.out.println(l);
		float f = (float) 2.08;
		System.out.println(f);
		double dolly = 13.13;
		System.out.println(dolly);

		int humanAge = 20;
		System.out.println(humanAge);
		System.out.printf("%d\n", humanAge);

		String firstName = "Hong gil dong";
		char lastName = '홍';
		System.out.println(lastName);
		System.out.println(firstName);
		boolean tf = true;
		boolean tf2 = false;
		System.out.println(tf);
		System.out.println(!tf);
		System.out.println(tf^tf2);
	}
}
