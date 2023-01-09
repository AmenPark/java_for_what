import java.util.Random;
import java.util.Scanner;

// 지금은 하나의 클래스에게 주도권을 주고 짠 코드이다.
// 3개의 객체-심판과 플레이어 둘을 주체로 삼고 게임을 진행한다면?
// 심판이 시작을 선언. 각 플레이어가 낼 것을 물어봄. 결과 판정. 정도로 진행된다.
// 즉 각 플레이어는 주체적으로 하기보다는 getter과 setter정도만 있으면 되는 그야말로 DTO일 것이다.
public class RSPComputer {
	boolean power;
	int tries;
	int wincount;
	int winmaxcount;
	int choice;
	final static String[] RSParr = {"가위", "바위", "보"};
	Random _r;
	Scanner c;
	
	public void on() {
		power = true;
		_r = new Random();
		tries = 0;
		wincount = 0;
		winmaxcount = 0;
		c = new Scanner(System.in);
	}
	
	public void startGame() {
		System.out.println("가위: 0, 바위:1, 보:2, 기타는 프로그램 종료입니다.");
		while(power) {
			playGame();
		}
		System.out.printf("당신의 최고 연승기록은 %d회 입니다.\n", winmaxcount);
	}
	
	public void playGame() {
		if(power) {
			setRSP();
			calc();
		}
	}
	
	private void setRSP() {
		choice = _r.nextInt(3);
	}
	
	private void calc() {
		System.out.print("당신의 선택은?:");
		int user = c.nextInt();
		if (user<0 || user>2) {
			System.out.print("잘못된 입력. 시스템을 정지합니다.");
			power=false;
		}else {
			System.out.printf("당신의 선택: %s\n", RSParr[user]);
			System.out.printf("컴퓨터의 선택: %s\n", RSParr[choice]);
			switch((user-choice+3)%3) {
			case 0:
				System.out.println("무승부!");
				winmaxcount = winmaxcount<wincount?wincount:winmaxcount;
				wincount=0;
				break;
			case 1:
				System.out.println("승리!");
				wincount++;
				break;
			case 2:
				System.out.println("패배!");
				winmaxcount = winmaxcount<wincount?wincount:winmaxcount;
				wincount = 0;
				break;
			default:
			}
		}
		
		
	}
	
}
