
public class Human {
	String name;
	String from;
	Dog dog;
	public Human(String name, String from, Dog dog) {
		super();
		this.name = name;
		this.from = from;
		this.dog = dog;
	}
	public Human(String name, String from) {
		super();
		this.name = name;
		this.from = from;
	}
	public void printinfo() {
		System.out.println(name);
		System.out.println(from);
		if (dog!=null) {
			dog.printinfo();
		}
	}
	
}
