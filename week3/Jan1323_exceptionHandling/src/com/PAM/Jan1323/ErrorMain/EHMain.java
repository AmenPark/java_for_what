package com.PAM.Jan1323.ErrorMain;

import com.PAM.Jan1323.makeError.Calcul;

// error : Java 문법에 안 맞게 써서 compile을 못함. 빨간줄? 전적인 개발자 잘못.
// warning : 노란줄. 작동에 문제는 없지만 의미가 불분명한 변수선언이 대표적.
//			정리가 안된 소스로 실행에 문제는 없음. 개발자 잘못. 정리해주는게 좋음.
// exception : 정상적인 프로그램이나 외부적 요인에 의해 문제가 생김.
// 			개발자 잘못은 아닌데 그 상황에 대응을 해 줘야 좋음.

//int a=3; // warning
//a // error
//System.out.println(3/0); // exception

// try-exception. try를 실행하다 exception을 만나면 catch로 감.
// error e에 대해서 e.printStacTrace()를 통해 에러 처리가 가능하다.

//throws : 미루기. try-catch는 직접 한다면, throws는 예외의 케이스에 에러를 던져줌.
//해당 함수에서 throws가 있으면 해당 에러가 날 수 있다는 것. 호출한쪽에서 처리한다.
// 예외사항을 처리하지 않으면 에러가 난다.
public class EHMain {
	public static void main(String[] args) {

//		try {
//			System.out.println(3/0);
//		} catch (Exception e) {
//			e.printStackTrace(); // 개발자용.
//		} finally {
//			//끝나고나서 진행할 것. try를 진행하다가 사고가 터지면 catch로 넘어간다.
//			// 따라서 finally를 통해 최종적으로 실행할 코드를 작성.
//			// 사실 그냥 try-catch 문 바깥쪽에 작업해도 되지 않을까 싶기는 하다.
//			 return 이 중간에 끼어 있을 경우에만 유의미하다.
//		calcul에서 return 이전에 final을 할 수 있음을 알 수 있다. 체크해보자.
//		}
		int[] a = { 1 };
		a[0] = Calcul.divide(5, 0, a);
		System.out.println(a[0]);

		try {
			int z = Calcul.divide2(5, 0);
			System.out.println(z);
		} catch (ArithmeticException e) {
			System.out.println("나누기0은 불가능");
		}
		
		
	}
}
