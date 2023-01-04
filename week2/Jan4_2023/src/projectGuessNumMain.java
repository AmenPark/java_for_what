import java.util.Random;
import java.util.Scanner;

public class projectGuessNumMain {
	private static int getAns(Random _r) {
		return _r.nextInt(10000);
	}
	public static int getYourAns(Scanner _in) {
		return _in.nextInt();
	}
	
	public static void main(String[] args) {
		Random _r = new Random();
		Scanner _in = new Scanner(System.in);
		
		int var;
		int ans = getAns(r);
		int i = 0;
		System.out.println();
		while(true) {
			i++;
			var = getYourAns(_in);
			if(var == ans) {
				System.out.printf("%d번째만에 정답 성공!",i);
				break;
			} else if (var>ans) {
				System.out.println("Down");
			} else {
				System.out.println("UP");
			}
		}
	}
}
