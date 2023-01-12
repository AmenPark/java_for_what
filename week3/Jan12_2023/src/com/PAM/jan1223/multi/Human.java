package com.PAM.jan1223.multi;

/*
 * 인터페이스는 멤버변수 사용 불가능. 즉, class의 하위호환?
 * 멤버상수는 사용 가능.
 * static만 사용 가능?
 * 추상메소드도 사용 가능.
 * 잘 사용하지 않으면 오히려 복잡해질수 있음.
 * 
 * 일반 class
 * 멤버변수, 멤버상수, 메소드 가능. 추상메소드 불가능.
 * 추상 abstract class - 객체생성 불가능.
 * 멤버변수, 멤버상수, 메소드, 추상메소드 가능.
 * 인터페이스 interface - 객체생성 불가능.
 * 멤버변수나 메소드 불가능. 멤버상수,추상메소드 가능.
 */
public interface Human {
	public static final String AtNight = "sleep";

	public static void goMart() {
		System.out.println("go to mart");
	}

	public abstract void eat();
}
