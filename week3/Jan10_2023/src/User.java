import java.util.Scanner;

public class User {
	static Scanner mouth = new Scanner(System.in);
	public int tell() {
		System.out.print("추측한다:");
		return mouth.nextInt();
	}
}
