// ctrl+shift+/ -> 모두닫기
// ctrl+shift+* -> 모두 열기 
// ctrl + / -> 줄임옵션 해제-생성
// ctrl + +- -> 단락줄임/단락열기
// 모든건 numpad 기준이다.

// 함수 오버로딩 - 파라미터의 자료형과 매개변수 수 등이 다르면 함수명이 같아도 됨. 호출시 구분가능.
// 비슷한 기능일때 일부러 함수명을 같게 짓는 테크닉. println이 대표적. 타입이 달라도 다 프린트됨.

// 함수명 짓는 방식? 동사를 앞으로 당기든 주체를 앞으로 당기든, camelcase. 
// 재귀함수.
public class FuncMain {
	public static void name() {
		System.out.println("대충내용");
	}

	public static int getvar(int var) {
		System.out.printf("입력된 숫자는 %d 입니다\n", var);
		return var + 1;
	}

	public static void printSum(int a, int b, int c) {
		int ans = a + b + c;
		System.out.println(ans);
	}

	public static void getEvenOrOdd(int var) {
		System.out.println(var % 2 == 0 ? "짝수입니다" : "홀수입니다");
	}

	public static float getAverage(int a, int b) {
		return ((float) a + b) / 2;
	}

	public static double convertMilliSec(double a) {
		return 1000 * a;
	}

	public static int getBiggerNumber(int a, int b) {
		return (a > b ? a : b);
	}

	public static int getSumGauss(int a) {
		return a == 0 ? 0 : (getSumGauss(a - 1) + a);
	}

	public static int getFactorial(int n) {
		return n == 0 ? 1 : getFactorial(n - 1) * n;
	}

	public static int getPhiboSub(int a, int b, int n, int d) {
		return d >= n ? b : getPhiboSub(b, a + b, n, d + 1);
	}

	public static int getPhibo(int n) {
		return n <= 2 ? 1 : getPhiboSub(1, 1, n, 2);
	}
	

	public static void main(String[] args) {
//		name();
//		System.out.printf("리턴된 숫자는 %d 입니다.\n",getvar(15));

		System.out.println(getPhibo(50));
		

	}
}


