import java.util.Random;
import java.util.Scanner;

public class gameRSPMain {
	public static int getRSP(Scanner _in) {
		System.out.print("가위-1, 바위-2, 보-3:");
		int var = _in.nextInt();
		return (var>0&&var<4)?(var-1):getRSP(_in);
	}
	public static int getComRSP(Random _r) {
		return _r.nextInt(3);
	}
	public static int getResult(int com, int user) {
		if (user == com) {
			System.out.println("비김!");
			return 0;
		}else if ((com-user)%3<0){
			System.out.println("이김!");
			return 1;
		}else {
			System.out.println("짐!");
			return -1;
		}
		
	}
	public static void main(String[] args) {
		
		Scanner _in = new Scanner(System.in);
		Random _r = new Random();
		// 1-가위, 2-바위, 3-보.
		int maxct = 0;
		int ct=0;
		fx : while(true) {
			switch (getResult(getComRSP(_r), getRSP(_in))){
			case 0:
				maxct=  maxct<ct?ct:maxct;
				ct = 0;
				break;
			case 1:
				ct++;
				break;
			default:
				maxct = maxct<ct?ct:maxct;
				System.out.printf("가위바위보 %d 연승!",maxct);
				break fx;
			}
		}
		
		
	}
}
