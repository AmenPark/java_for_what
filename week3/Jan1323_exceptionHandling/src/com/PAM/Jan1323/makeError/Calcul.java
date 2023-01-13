package com.PAM.Jan1323.makeError;

public class Calcul {
	
	public static int divide(int a,int b, int[] checker) {
		try {
			System.out.println(a/b);
			return 200;
		} catch (Exception e) {
			System.out.println("0으로 나눌 수 없습니다.");
			return -1;
		} finally {
			System.out.println("끝");
			System.out.println(checker[0]);
		}
		
	}
	
	public static int divide2(int a, int b) throws ArithmeticException {
		return a/b;
	}
}
