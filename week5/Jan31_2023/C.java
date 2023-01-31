package com.PAM.Jan312023;

// Controller.
/* 상황판단해서 V, M을 적절히 배치.
 * 
 */
public class C {
	public static void main(String[] args) {
		int n =V.getNum();
		String result = M.judge(n);
		V.print(result);
		
	}
}
