package _01_06;
// class명은 대문자 시작?
public class Dog {
	String name;
	double weight;
	boolean isMale;
	int age;
	// dog라는 class이므로 생성자 이름도 dog이다.
	public Dog(String n,int age, double w, boolean m){
		this.name = n;
		this.weight = w;
		this.isMale = m;
		this.age = age;
	}
	
	public static void bark() {
		System.out.println("bark!");
	}
	
	public void printInfo() {
		System.out.println(this.name);
	}
	
}
