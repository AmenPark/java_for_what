import java.util.Scanner;

public class InputMain {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("x :");
		long x = keyboard.nextLong();
		System.out.print("y :");
		int y = keyboard.nextInt();
		System.out.println("--------");
		System.out.printf("x는 %d, y는 %d", x, y);
		keyboard.close();
	}
}
