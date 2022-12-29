package test_221229;

import java.util.Scanner;

// =+-*/%&^|<<>>
// ++x 는 x+1 이후 연산. x++은 연산후 x+1.
public class OperatorMain {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("x :");
		long x = keyboard.nextLong();
		System.out.print("y :");
		int y = keyboard.nextInt();
		System.out.println("--------");
		System.out.printf("x는 %d, y는 %d\n", x, y);
		keyboard.close();
		float d = (float)x/y;
		System.out.println(x+y);
		System.out.println(x-y);
		System.out.println(d);
		System.out.println(x*y);
		System.out.println(x%y);
		
		x+=3;
		System.out.println(x);
		x++;
		++x;	// 이거 별로임. 잘 안씀.
		System.out.println(x++);
		System.out.println(++x);
		
		int dd=2;
		System.out.println((dd<<-2));

	}
	
	
}
