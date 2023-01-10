 /* WORA - write once run anywhere. os에 따라 다른 프로그램을 만들었어야 했으나 하나의 코드로 실행 가능해짐.
  * java virtual machin - JVM이 만들어져서 os와 무관하게 실행 가능하도록 만듬. JRE에 존재.
  * 기계어로 번역된 것들이 stack에 생김?
  * static method - method 앞에 static이 붙음. class에서는 잘 사용하지 않음. main에는 사용.
  * 메소드는 메모리 공간을 먹는애가 아니다.
  * 객체 없이도 쓸 수 있는 함수.
  * Class.method() 꼴로 사용.
  * JVM이 main을 호출한다. 객체를 만들고 하는게 아니기 때문에 main함수는 static해야 실행 가능하다.
  * static은 객체 없이 쓸 수 있기에, static 변수를 제외하면 다른 변수를 사용 불가능하다.
  * 무조건 객체 만들어서 함수 만든다가 아니다. 멤버변수가 필요하지 않다면 객체생성조차 필요없이 static으로 쓰는게 좋을지도.
  * 나중에는 객체를 자동으로 만들어줌. 기본생성자로 만듬...
  * 오버로딩된 생성자를 많이 쓰겠지...
  * window-preference 에서 단축키를 지정한다.
  * general-keys에서 단축키 지정 가능. refactoring이라던지 gnerate constructors using field같은 단축키를 마음대로 설정 가능. 후자는 매우 유용하니 설정해주면 좋다.
  */
public class goodDayMain {
	public static void testGanjanGejang() {
		System.out.println(GanjangGejang.creater);
		GanjangGejang g1 = new GanjangGejang();
		g1.name = "설특선간장게장세트";
		g1.weight = 10;
		g1.price = 39900;

		GanjangGejang g2 = new GanjangGejang();
		g2.name = "양념게장세트";
		g2.weight = 5;
		g2.price = 29900;
		
		g1.printInfo();
		g2.printInfo();
	}
	
	public static void testCalculator() {
		Calculator c = new Calculator();		// static으로 선언해서 쓰면 더 좋은 케이스.
		System.out.println(c.times(10, 20));
	}

	public static void testComputer() {
		// cpu자체는 static하지 않다..고 주장하시긴 하는데. 실질적 사용과 언제나 고정이라면 쓰는것도 나쁘지 않다.
		// 다만 차후 바뀔 가능성이 있으니 static 하지 않는것이 맞긴 하다.
		Computer.printmadeby();
		Computer com1 = new Computer();
		com1.ram = 16;
		com1.hdd = 500;
		com1.printinfo();
	}
	
	public static void testShopping() {
		Items i1 = new Items();
		i1.printInfo();
		
		Items i2 = new Items("그래서 뭐", 200000);
		i2.printInfo();
		
		Items i3 = new Items(3000);
		i3.printInfo();
		
		Items i4 = new Items("가격안씀");
		i4.printInfo();
	}
	
	public static void testMenu() {
		Menu m = new Menu("양꼬치",9000);
		m.printinfo();
	}
	
	public static void testUpDown() {
		UpdownCom com = new UpdownCom();
		com.start();
	}
	
	public static void testOOP() {
		Dog d = new Dog("후추", 3);
		Human h = new Human("홍길동", "수원");
		Human h2 = new Human("개장수", "수원", d);
		d.printinfo();
		System.out.println("==========");
		h.printinfo();
		System.out.println("==========");
		h2.printinfo();
		System.out.println("==========");
		
		Company s = new Company("삼성", 100, h2);
		s.printinfo();
		System.out.println("==========");
		
		Phone p = new Phone("플립3", 7200000, s);
		p.printinfo();
		System.out.println("==========");
		
		
		// p 만든회사
		System.out.println(p.madeby.name);
		System.out.println("==========");
		// 사장님
		
		
	}
	public static void main(String[] args) {
//		testComputer();
//		testCalculator();
//		testGanjanGejang();
//		testShopping();
//		testMenu();
//		testUpDown();
		testOOP();
	}
}
