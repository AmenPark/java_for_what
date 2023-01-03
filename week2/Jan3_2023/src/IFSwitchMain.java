import java.util.Scanner;

// 조건문, 반복문, 배열.
// switch는 존재는 하지만 의미가 있나? 싶음.
//dba, dbp, dbu. db이용하기? db admin, db prod, db user?
public class IFSwitchMain {
	
	public static double getDouble(Scanner _in, String sentence) {
		System.out.print(sentence);
		return _in.nextDouble();
	}
	
	public static double getBMI(double height, double weight) {
		return weight / (height/100.0) / (height/100);
	}
	
	public static String getResult(double bmi) {
		if (bmi<18.5){
			return "저체중";
	    } else if (bmi<23) {
	    	return "정상";
	    } else if (bmi<25) {
	    	return "과체중";
	    } else {
	    	return "비만";
	    }
	}
	
	public static void yourScore() {
		Scanner _in = new Scanner(System.in);
		System.out.print("중간고사:");
		int midPt = _in.nextInt();
		System.out.print("기말고사:");
		int finPt = _in.nextInt();
		System.out.println("------------");
		double avgPt = (midPt+finPt)/2.0;
		System.out.printf("평균점수는 %.1f점\n", avgPt);
		
		
		//흐름제어.
		int stdpt = 9;
		if (avgPt>=10 * stdpt--) {
			System.out.println("수 입니다.");
		} else if (avgPt>=10 * stdpt--) {
			System.out.println("우 입니다.");
		}else if (avgPt>=10 * stdpt--) {
			System.out.println("미 입니다.");
		}else if (avgPt>=10 * stdpt--) {
			System.out.println("양 입니다.");
		}else {
			System.out.println("가 입니다.");
		}
	}
	
	public static void yourBMI() {
		Scanner scanner = new Scanner(System.in);
	    double weight = getDouble(scanner, "체중을 입력하세요:");
	    double height = getDouble(scanner, "키를 입력하세요:");
	    double bmi = getBMI(height, weight);
	    System.out.printf("Your BMI is %.2f\n", bmi);
	    String result = getResult(bmi);
	    System.out.println(result);
	    scanner.close();
	}
	
	public static void Dinner() {
		Scanner _in = new Scanner(System.in);
		System.out.print("사람 수");
		int n = _in.nextInt();
		System.out.println("=====");
		System.out.printf("%d명\n", n);
		switch (n) {
		case 5:
			System.out.println("예약해라");
			break;
		case 3:
			System.out.println("즉흥적으로");
			break;
		default:
			break;
		}
	}
	
	public static void switchTest() {
		String rank = "일병";
		
		
		switch (rank) {
		case "이병":
			System.out.println("눈치");
		case "일병":
			System.out.println("관등성명");
		case "상병":
			System.out.println("훈련");
		case "병장":
			System.out.println("잠");

		default:
			break;
		}
	}
	
	public static void checkAuth() {
		String role = "DBA";
		switch (role) {
		case "DBA":
			System.out.println("전원/계정관리");
			System.out.println("백업/복구");
		case "DBP":
			System.out.println("CRUD");
		case "DBU":
			System.out.println("서비스 이용");
		default:
			break;
		}
	}
	public static void main(String[] args) {
		
//		yourScore();
//		yourBMI();
//		Dinner();
//		switchTest();
		checkAuth();
		
	    
	    
		
	}
}

