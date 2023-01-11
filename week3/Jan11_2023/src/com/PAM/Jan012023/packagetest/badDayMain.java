package com.PAM.Jan012023.packagetest;

/*
 * 메인 건들기 안하고 class만 작성할듯.
 * public final class A extends B -> A는 B를 상속받음. 근데 final이라 더 이상 상속이 불가능.
 * final int k = 10000; -> 상수. k는 더 이상 수정 불가능.
 * public final void func() -> func는 final으로 subclass에서도 오버라이딩 불가능.
 * 어제 뭘 잘못먹었나.... 배가 슬슬 안좋더니만 점심시간 전에 비우네..
 * 단축키로 설정한 생성자 기본생성시 위에서 설정해서 오버로딩된것들중 하나를 선택해서 가능.
 * 클래스명은 중복 안 되도록 짜야한다. 겹칠 경우에는...
 * new 패키지명.생성자; -> 이걸로 객체생성.
 * 근데 이 객체를 생성하기 위한것들은 다 패키지에 속해있었음.
 * java.util <- 패키지명. 클래스명을 java.util.Scanner처럼 패키지명까지 쓰면 중복된 클래스여도 사용 가능.
 * 그러니까 패키지에 클래스가 속해 있다.
 * 패키지명 중복시에는? 뭐가 없음. 그러니까 패키지명은 중복 안되게 할 것. 세계적으로 중복 안되는게 좋음.
 * 그래서 패키지명은 회사홈페이지주소 거꾸로쓰는 느낌. com.회사명.프로그램명.카테고리 같은 방식으로 쓴다.
 * 패키지도 잘 작성하는 습관을 들여주자.
 * java.lang이라는 기본패키지는 생략 가능하다.
 * 같은 패키지명도 생략 가능하다.
 * import mypackage.Class -> Class만 나오면 이건 mypackage의 것이다. 즉, import시 package를 생략 가능.
 * 이클립스에서 ctrl+space는 import까지 알아서 해 준다.
 * ctrl+shift+o : import를 정리해주는 단축키.
 * 
 * access modifier - 접근제어자/지정자/제한자. 접근을 제어하는 역할.
 * private/default/protected/public 순으로 제한이 점차 풀림.
 * private - 같은 클래스 내에서만 접근 가능. default - 그냥 int 등으로 적을경우가 바로 이것. 동패키지에서만 접근 가능.
 * protected - 동일패키지의 클래스 또는 해당 클래스를 상속받은 다른 패키지의 클래스만 접근 가능
 * public - 공개
 * 이건 변수 지정, 메소드, 클래스 등에서 함께 쓰일 수 있다.
 * 그런데 protected에는 버그가 있다? default와 같아져버리는 버그?
 * 주제별로 패키지 정리. main에서 쓸 것은 public을 준다.
 * 근데 권한 등은 캡슐화를 하는게 좋다.
 * 1. 멤버변수는 private로 만들 것. 외부에서 접근 불가능.
 * 2. 권한 있는 사람이 접근할 수 있는 통로를 생성. getter, setter? 생성자와 마찬가지로 단축키가 아쉽다. 단축키를 주자.
 * 3. 기본생성자도 배치.
 * 4. 기타 메소드도 생성.
 */
public class badDayMain {

	public static void testCoffee() {
//		Student s = new Student("길동", 200);
		Student.drinkCoffee();
	}	
	
	public static void testInheritance() {
//		Computer c = new Computer();
//		c.name = "매직스테이션213";
//		c.cpu = "i7-1231";
//		c.price = 200000;
//		c.ram = 16;
//		c.hdd = 500;
//		c.printinfo();
		Computer c= new Computer("매직스테이션213", 2000000, "i7-1231", 16, 500);
		c.printinfo();
		
		Laptop l = new Laptop("그램234", 2500000, "I7-6553", 16, 1000, 2.0, 500);
		l.printinfo();
	}
	
	public static void testParallelInheritance() {
		Meat m = new Meat("티본스테이크", 100000, "미디엄웰던");
		Drinks d = new Drinks("처음처럼", 3000, 15);
		m.printinfo();
		d.printinfo();
		OddRandom o = new OddRandom();
		System.out.println(o.nextInt(1));
		Milk k = new Milk();
		k.printinfo();
	}
	
	public static void testM() {
		Display d = new Display("모나미153", 500, "모나미");
		Display d2 = new Display("로지텍123", 10000, "로지텍 마우스");
		d.printinfo();
		d2.printinfo();
		Display d3 = new Display("캐논123", 500000, "캐논 스캐너");
		d3.printinfo();
		
	}
	
	public static void testS() {
		System.out.println("정리끝?");
		accessRestrictedHuman h = new accessRestrictedHuman("홍길동", 30);
		h.printinfo();
		h.setAge(25);
		h.printinfo();
	}
	
	
	public static void main(String[] args) {
//		testCoffee();
//		testInheritance();
//		testParallelInheritance();
//		testM();
		testS();
	}
}
