package com.PAM.Jan012023.packagetest;
/*
 * 상속 키워드 extends. 클래스명 extends 상속받을 클래스.
 * overriding - 상속받은 메소드의 재정의. overloading은 동일메소드명 다른 매개변수배치로 비슷한 역할하는 것을 묶어 쓰는경우이다.
 * @ : annotation. 옆에 들어가는것에 따라 컴파일러에게 알려준다. @ override면 오버라이드라고 알려주는것.
 * 소스 가독성을 위한것. 사실 없어도 되는데 메소드가 오버라이딩되지 않는, 철자미스가 났을 경우 등을 방지해준다.
 * super - 상위클래스. 상위클래스의 무엇인가를 할 때에 super.을 사용한다. this에 대응되는 문법? Milk로서의 객체 - this, Item으로서의 객체 - super.
 */
public class Milk extends Item{
	String expDate;
	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println(expDate);
	}
}
