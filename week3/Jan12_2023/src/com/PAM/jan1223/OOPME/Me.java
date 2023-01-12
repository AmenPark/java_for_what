package com.PAM.jan1223.OOPME;

/* Singletone pattern. only one 객체. 이 객체는 유일하다.
 * 생성자를 private로 만들기.
 * 객체는 내부에서 생성. 수정도 못함.
 * getter을 통해 해당 객체를 외부에서 쓸 수 있도록 한다.
 */
public class Me {
	public static final String Name = "PAM";
	private static String addr = "관악";
	private int age;
	private static final Me me = new Me(30);
	
	private Me(int age) {
		this.age = age;
	}

	public Me() {
		System.out.println("test");
		
	}
	
	// getInstance()라는식으로 쓰는 경우가 많다.
	public static Me getInstance() {
		return me;
	}
	
	
	
	
	
	
}
