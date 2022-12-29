package test_221229;

import java.util.Scanner;

public class LogicOperationMain {
	public static void main(String[] args) {
		

		
		Scanner _in = new Scanner(System.in);
		System.out.print("이름 :");
		String name = _in.next();
		System.out.print("키 :");
		double height = _in.nextDouble();
		System.out.print("나이 :");
		int age = _in.nextInt();
		
		System.out.println("------------");
		System.out.printf("이름은 %s, 키는 %.0fcm, 나이는 %d살\n", name, height, age);
		
		//변수를 앞으로 배치하는게 좋다.
		System.out.printf("키는 120 이상인가? :%b\n", height>=120);
		System.out.printf("나이는 10살 미만인가? : %b\n", age<10);
		System.out.printf("나이가 정확히 5살인가?: %b\n", age==5);
		System.out.printf("나이가 홀수인가?: %b\n", age%2 == 1);
		System.out.printf("이름이 홍길동인가?: %b\n",name.equals("홍길동"));
		
	}
}
			