import java.util.Random;
import java.util.Scanner;

public class Guest extends Human {
	double height;
	double weight;
	Scanner mouth = new Scanner(System.in);
	double bmi;
	
	public Guest(String n, int m, double h, double w){
		super(n,m);
		height = h;
		weight = w;
	}
	
//	public Guest() {
//		String n = randomName();
//		int m = randomInt();
//		double w = randomDouble(30,130);
//		double h = randomDouble(90,230);
//		System.out.println(n);
//	}
	
	
	
	private String randomName() {

		Random _r = new Random();
		int n = _r.nextInt(26);
		String x = "";
		for(int i=0;i<5;i++) {
			x += (char)(n+65); 
		}
		return x;
	}

	private int randomInt() {
		Random _r = new Random();
		int n = _r.nextInt(90);
		return n+3;
	}
	
	private double randomDouble(double a, double b) {
		Random _r = new Random();
		int n = _r.nextInt(((int)(b-a))*10);
		return (a*10+n)/10.0;
	}
	

	
	public String answer() {
		return mouth.next();
	}
	
	public double getDouble() {

		return mouth.nextDouble();
	}
}
