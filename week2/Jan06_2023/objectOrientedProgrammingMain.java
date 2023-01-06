package _01_06;
// 절차지향 프로그래밍.
// 조건문, 반복문 등을 적재적소에 배치해서 프로그램을 완성시키자.
// 발전에 따라 최적화가 별로 안중요해졌다.
// 객체지향의 등장.
// 개발속도나 유지보수 등이 아주 좋아졌다.


public class objectOrientedProgrammingMain {
	public static void main(String[] args) {
		Dog hoochoo = new Dog("hoochoo",  3, 18, false);
		hoochoo.bark();
		hoochoo.printInfo();
	}
}
