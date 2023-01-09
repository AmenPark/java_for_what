// 객체지향 프로그래밍.
// 현실의 작동 원리를 모방한 프로그래밍 방법.
// 
public class objectOrientedMain {
	public static void main(String[] args) {
//		//Human.java가 존재하기에 가능한 자료형. new로 선언해준다.
//		Human person = new Human();	
//		person.name = "홍길동";
//		person.age = 20;
//		person.eat();
//		person.introduce();
//		
//		System.out.println("=========");
//		Human p2 = new Human();
//		p2.name = "김길동";
//		p2.age = 30;
//		p2.introduce();

		// class의 field? attribute? 들은 기본값이 존재. 0 또는 null.
		Calculator C = new Calculator("카시오2134", 34500);
		C.printinfo();
		C.printSum(20, 30);

		Calculator C2 = new Calculator("구글계산기", 2147483647);
		C2.printinfo();
		C2.printSum(100, 120);
		
		C2 = null;
		//null pointer Exception. 널이라서 못함.
//		C2.printSum(13, 0);
	}
}
