
public class Calculator {
	// 여기에 초기값 설정도 가능하지만 전혀 좋은 코드가 아님.
	String Name ;
	int price ;
	
	public Calculator(String n, int p) {
		Name = n;
		price = p;
	}

	
	public void printinfo() {
		System.out.println(Name);
		System.out.println(price);
	}
	
	public void printSum(int a, int b) {	
		System.out.println(a+b);
	}
}
