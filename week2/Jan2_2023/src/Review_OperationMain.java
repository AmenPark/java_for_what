import java.util.Scanner;

// && - and. || = or. ! - not. ^ - xor.
// &, | 는 비트연산이다. &&, ||은 논리연산. 비트연산은 무조건 다 연산. 논리연산은 하나가 false면 나머지는 안보고 and처리.
// xor은 어쩔 수 없이 다 연산하기에 비트연산 논리연산 구분이 없는듯.
// 3항연산자 a?b:c

public class Review_OperationMain {
	public static void main(String[] args) {
		Scanner _in = new Scanner(System.in);
		System.out.print("나이 :");
		int age = _in.nextInt();
		System.out.print("키 :");
		double height = _in.nextDouble();
		System.out.println("------------");
		System.out.printf("나이는 %d살, 키는 %.0fcm\n", age, height);

		System.out.printf("키가 150 이상인가요? : %b\n", height >= 150);
		System.out.printf("나이가 80이상 또는 키가 100이상인가? : %b\n", age >= 80 || height >= 100);
		// 논리연산자 and, or을 할 때에는 더 많이 필터링 가능한 쪽을 앞으로 두는 것이 좋다. 즉 위의 경우는 반대로 쓰는게 좋다.
		System.out.printf("not 80이상. %b\n", !(age>=80));
		System.out.printf("120이상, 150이상? %b\n", height >=150);
		
		String say = (age<50)? "젊군": "늙었군";
		System.out.println(say);
	}
}
