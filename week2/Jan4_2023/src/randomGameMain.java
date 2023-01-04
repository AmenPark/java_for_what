import java.util.Random;
import java.util.Scanner;
// 랜덤은 scanner처럼 사용 가능하다.
// while 처럼 for을 사용 가능하다.
// 반복문 제어 - break, continue
// while, for 등에 X:while 과 같이 이름을 붙여줄 수 있다. break X 하면 인근for 등을 무시하고 X라는 이름의 while이 강제break.
// 이중포문 등을 탈출하기 좋을지도?
// 변수명이 아니기 때문이 X라는 변수를 쓰면서도 X:while이 가능하다. break continue 뒤에 변수가 붙을 수 없으니 컴파일러가 구분 가능해서 그런듯.
public class randomGameMain {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner _in = new Scanner(System.in);
//		System.out.println(false||"값");

		// int target = -1;
//		while (target != 5) {
//			target = r.nextInt(10);
//			System.out.println(target);
//		}

//		String msg = "";
//		System.out.println("");
//		while(!(msg.equals("bye"))) {
//			msg = _in.nextLine();
//		}
//		for(;!(msg.equals("bye"));) {
//			msg = _in.nextLine();
//		}
//		System.out.println(msg);
//		int rvar;
//		do {
//			rvar = r.nextInt(100);
//			System.out.println(rvar);
//		} while (rvar%5!=1);
		String a;
		System.out.println("");
		int k = 0;
		k: while(true) {
			k+=1;
			a = _in.next();
//			if (a.equals("bye")) {
//				break;
//			}
			switch (a) {
			case "bye":
				break k;
			default:
			}
		}
		System.out.println(k);
		_in.close();

	}
}
