
public class Menu {
	String name;
	int price;
	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void printinfo() {
		System.out.println(name);
		System.out.println(price);
	}
}
