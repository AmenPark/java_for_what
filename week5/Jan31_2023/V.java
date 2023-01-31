package com.PAM.Jan312023;

import java.util.Scanner;

/*
 * scanner은 한번 닫으면 그 실행동안은 못쓴다...??
 */

public class V {
	private Scanner inputSystem;
	public V() {
		inputSystem = new Scanner(System.in);
	}
	public void destroy() {
		inputSystem.close();
	}
	public static int getNum() {
		
		Scanner s = new Scanner(System.in);
		System.out.print("숫자입력: ");
		int n = s.nextInt();
//		s.close();
		return n;
	}
	
	public static void print(String result) {
		System.out.println(result);
	}
	
	public static void print(int i) {
		System.out.println(i);
	}
}
