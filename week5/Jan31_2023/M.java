package com.PAM.Jan312023;

public class M {
	public static String judge(int n) {
		if (n%2==0) {
			return "짝수";
		}else {
			return "홀수";
		}
	}
	
	public static int[] calcul(int a, int b) {
		int[] rt = {a+b,a-b,a*b,a/b};
		return rt;
	}
}
