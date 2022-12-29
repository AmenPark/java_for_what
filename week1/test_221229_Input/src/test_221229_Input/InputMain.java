package test_221229_Input;

import java.util.Scanner;

public class InputMain {
	private static String GetGender(boolean b) {
		if(b) {
			return "Male";
		}else {
			return"Female";
		}

	}
	public static void main(String[] args) {
		// 콘솔 키보드 입력. 자동완성시 필요하다면 import 부분을 생성해 준다.
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Name :");

		String nameData = keyboard.nextLine();
		System.out.print("where :");
		String whereData = keyboard.nextLine();
		System.out.print("age :");
		int ageData = keyboard.nextInt();
		System.out.print("eyeVision :");
		float eyeData = keyboard.nextFloat();
		System.out.print("Are you male? :");
		boolean isMale = keyboard.nextBoolean();
		System.out.println("--------");
		
		System.out.printf("My name is %s\n", nameData);
		System.out.printf("And I leave in %s\n", whereData);
		System.out.printf("And my age is %d\n", ageData);
		System.out.printf("And my eye vision level is %.1f\n", eyeData, isMale);
		System.out.printf("And my gender is %s\n", GetGender(isMale));
	}
}
