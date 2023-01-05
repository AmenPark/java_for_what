
public class funcMain {
	public static int printSum(int a, int b) {
		return (a + b);
	}

	public static int printSum(int a, int b, int c) {
		return (a + b + c);
	} // 함수 오버로딩. 동함수명 동기능 조금 다른 인자.

	// call by reference vs call by value의 차이.
	public static void checkVar(int a, int[] b) {
		a+=10;
		b[0]+=10;
		
	}

	public static int printTimesAll(int... a) {
		int rt = 1;
		for (int x : a) {
			rt *= x;
		}
		return rt;
	} // 함수 가변인자.

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(printSum(a, b));
		System.out.println(printSum(a, b, 30));

	}
}
