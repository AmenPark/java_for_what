import java.util.Random;
import java.util.Scanner;

public class UpdownCom {
	int answer;
	int count;
	int guess;
	boolean power;
	static Random _r = new Random();
	static Scanner _in = new Scanner(System.in);
	public UpdownCom() {
		count = 0;
		power = true;
	}
	
	public void start() {
		System.out.println("게임을 시작합니다.");
		setAns();
		while(power) {
			askAns();
		}
		
	}
	private void setAns() {
		this.answer = _r.nextInt(1000000)+1;
	}
	
	private void askAns() {
		System.out.print("숫자를 추측하세요:");
		guess = _in.nextInt();
		count++;
		if (guess == answer) {
			System.out.println("맞았습니다!");
			System.out.printf("%d번만에 정답!", count);
			power = false;
		} else if (guess>answer) {
			System.out.println("그것보다 작습니다.");
		}
		else {
			System.out.println("그것보다 큽니다.");
		}
	}
	
	
}
