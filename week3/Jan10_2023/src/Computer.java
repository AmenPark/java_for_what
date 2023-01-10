
public class Computer {
	static String cpu = "i7-1231";
	int ram;
	int hdd;
	static final String MADEBY = "삼성";
	
	public static void printmadeby() {
		System.out.println(MADEBY);
	}
	public void printinfo() {
		System.out.println(cpu);
		System.out.println(MADEBY);
		System.out.println(ram);
		System.out.println(hdd);
	}
}
