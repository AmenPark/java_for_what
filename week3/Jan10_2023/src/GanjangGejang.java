/*
 * GanjanGejang.
 * static member variable - initial value is better.
 * all objects has same attribute.
 * if you change GanjanGejang1's static creater attribute, G2 also be changed.
 * static area, (not a stack or heap area) data would be made only once.
 * with final, this attribute, member variable would be final value.
 * it cannot be changed. be constant value.
 * static value can be used even if you don't make the instance.
 * 

 */
public class GanjangGejang {
	String name;
	double weight;
	int price;
	static final String creater = "김수미";
	/*
	 * print all informations.
	 */
	public void printInfo() {
		System.out.println(name);
		System.out.println(weight);
		System.out.println(price);
		System.out.println(creater);
		System.out.println("====================");
	}
	public static void test() {
		System.out.println("static");
	}
}
