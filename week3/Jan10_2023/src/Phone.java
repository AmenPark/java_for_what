
public class Phone {
	String name;
	int price;
	Company madeby;
	public Phone(String name, int price, Company madeby) {
		super();
		this.name = name;
		this.price = price;
		this.madeby = madeby;
	}
	public void printinfo() {
		System.out.println(name);
		System.out.println(price);
		madeby.printinfo();
	}
}
