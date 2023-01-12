package com.PAM.jan1223.OOP;
import com.PAM.jan1223.cars.Car;
import com.PAM.jan1223.cars.Factory;
import com.PAM.jan1223.heros.Herk;
import com.PAM.jan1223.heros.IronMan;
import com.PAM.jan1223.products.Item;
import com.PAM.jan1223.products.Milk;
import com.PAM.jan1223.students.Counselor;
import com.PAM.jan1223.students.Student;

/*
 * OOP의 장점.
 * 가독성 - 유지보수의 용이성. 실생활 묘사라 직관적.
 * 재사용성 - 클래스 단위로 작업하기 좋음.
 * 보안성 - 캡슐화, 정보은닉.
 * 안드로이드 app id가 패키지명으로 들어간다고함.
 * 멤버변수(private) - 생성자들 - getter,setter - 이후메소드. 순서대로 클래스 작성할것.
 * 다형성(polymorphism)? Product의 자식클래스 food, book에 대해서. product v4 = new food() 와 같은, 부모클래스로 자식클래스 선언 가능.
 * 동적 로딩. 상위타입 변수에 하위타입 담는게 가능하다. 즉, product에 food, book 뭐든 담을 수 있는것.
 * 이를 응용해서 배열에 여러개의 Object들을 담을 수 있다.
 * 다만 오버라이딩된 것은 오버라이딩된 상태로 접근 가능하지만, 오버라이딩이 아니라면 접근 불가능해 보인다.
 * 
 * 특수한 클래스의 경우-공장에서 찍어내기.
 * 다른 패키지에서 간섭 불가능하도록 하기. 같은패키지에 공장역할 할 클래스를 만들기. student를 만들 Counselor은 singletone.
 * 해당 클래스로 생성시 잡다한 것들은 자동화하기.
 * 해당 경우 여기에서는 id를 자동으로 붙여주었다.
 * 공장을 이용하면 다형성을 이용해서 "품목"을 찍어낼 수 있다.
 * 
 * 영웅으로 오버라이딩하기.
 * 근데 영웅-헐크, 영웅-아이언맨은 각자 공격방식이 있지만 영웅은 혼자서 공격하는게 없다.
 * 즉, 영웅은 카테고리로서 존재하나 추상적이다.
 * 기본 공격을 따로 만들어서 한다면 모를까, 사실상 Hero의 attack은 딱히 없기 때문에 -> abstract void attack(); 과 같이 정의된다.
 * 정말 암것도 한 줄도 안였기에 추상메소드라 말한다.
 * 이러한 추상메소드를 포함하는것을 추상클래스라 말한다.
 * 이 추상클래스의 자식클래스들은 언제나 모든 추상메소드를 오버라이딩해서 기능이 존재해야만 사용할 수 있다.
 * attack을 오버라이딩 하지 않고는 추상클래스를 상속받지 못한다.
 * 
 * 클래스는 코드의 재사용을 목적으로 만들어졌다. 객체지향은 특히 그렇다.
 * 자바에서는 객체를 만들면서 클래스를 만드는 것이 가능. 익명 내부클래스라고 한다. anonymous inner class. 자바만의 문법.
 * 자바는 다중상속을 지원하지 않는 언어임. 파이썬은 지원함.
 * mro라고 해서 다중상속이 이상하게 하면 메소드 탐색방법을 알 수 있음. 파이썬만. 자신 이후에는 상속 앞쪽에 위치한게 먼저 탐색대상이 되는듯.
 * 자바에는 마이너버전 다중상속이 존재. 인터페이스-구현을 이용한것.
 * 인터페이스는 implements라는 기능을 통해 여러 인터페이스를 이어받을 수 있음. 정확히는 구현이라함.
 * 그리고 여러 인터페이스를 구현한 인터페이스를 상속받은 클래스는 간접적으로 다중상속된셈.
 * 
 * 협업을 한다고 가정하자.
 * 공격하기 - 빔 발사가 출력되면 된다? 라고 다 설명해두고 이제 그걸 하면 된다.
 * 그런데, 공격이 beam? attack? 뭘 쓸지 어떻게 알겠는가?
 * 메모장으로 어떻게 한다. 말도 안 되는 소리이다.
 * 뭔가 하나를 주면 좋다. 추상클래스를 주거나, 인터페이스를 주거나. 이 경우에는 extends 또는 implements를 사용하면 메소드 등에 강제성이 존재. 매개변수 등도 강제됨.
 * 속성이 여러개일 수 있다. 아이언맨은 마블의 영웅이며 동시에 비행속성을 갖는다. 비행속성을 갖는 객체가 할 수 있는것과 영웅객체가 할 수 있는것을 모두 해야만 한다.
 * 이런 경우 interface를 통해 implements를 통해서 무엇을 만들지(overriding) 업무명령하달이 가능하다.
 */
public class OMain {
	public static void testMain() {
		Item i1 = new Item("이것이자바다", 30000, "홍길동이 씀");
		Item i2 = new Item("딸기맛요구르트", 1000, "내일까지 먹기");
		
//		i1.printinfo();
//		i2.printinfo();
		
		Item i3 = new Milk("서울우유", 130, null, 120);
		i3.printinfo();

	}
	public static void testStudentMain2() {
		// 만들것 - Student. 하지만 생성자는 쓸 수 없다. c를 통해서만 만들 수 있다.
		// c는 singletone이다. c를 통해 만들어지는 객체는 자동으로 넘버링이 되며, c는 다음 숫자 넘버를 알고있다.
		Counselor c = Counselor.getInstance();
		Student s1 = c.makeStudent("길동", 20, "청주");
		Student s2 = c.makeStudent("일반", 22, "충주");
		s1.printinfo();
		s2.printinfo();
	}
	public static void testCar() {
		Factory f = new Factory();
		Car c = f.makeCar("BUS");
		Car c2 = f.makeCar("Truck");
		c.printinfo();
		c2.printinfo();
	}
	public static void testHero() {
		Herk h = new Herk("배너", 35);
		IronMan i = new IronMan("토니", 40);
		
		h.printinfo();
		h.attack();
		
		i.printinfo();
		i.attack();

	}
	public static void main(String[] args) {
//		testMain(); 
//		testStudentMain2();
//		testCar();
		testHero();
	}
}
