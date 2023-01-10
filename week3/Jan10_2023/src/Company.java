
public class Company {
	String name;
	int employees;
	Human ceo;
	public Company(String name, int employees, Human ceo) {
		super();
		this.name = name;
		this.employees = employees;
		this.ceo = ceo;
	}
	public void printinfo() {
		System.out.println(name);
		System.out.println(employees);
		ceo.printinfo();
	}
	
}
