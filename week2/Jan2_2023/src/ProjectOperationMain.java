import java.util.Scanner;

// 비만도. 이름, 키, 몸무게를 입력으로 받는다.
// 표준체중, 비만도,
public class ProjectOperationMain {
	public static String getString(Scanner _in, String message) {
		System.out.print(message);
		return _in.next();
	}
	public static double getDouble(Scanner _in, String message) {
		System.out.print(message);
		return _in.nextDouble();
	}
	
	public static double getStandardWeight(double h) {
		return (h-100) * 0.9;
	}
	
	public static double getObesity(double weight, double stdW) {
		return (weight/stdW)*100;
	}
	
	public static void printInfo(String name, double stdW, double Obe) {
		System.out.printf("표준체중 : %.2fkg\n", stdW);
		System.out.printf("비만도 : %.2f%%\n", Obe);
		System.out.printf("%s씨는 %s입니다.\n", name, Obe > 120 ? "비만" : "정상");


	}
	
	public static void main(String[] args) {
		System.out.println("비만도 검사");
		Scanner _in = new Scanner(System.in);
		String name = getString(_in, "이름:");
		
		double height = getDouble(_in, "키:");
		double weight = getDouble(_in, "몸무게:");
		System.out.println("---------");

		double stdW = getStandardWeight(height);
		double Obesity = getObesity(weight, stdW);
		
		printInfo(name,stdW,Obesity);
		System.out.println("끝내기 위해서 엔터를 치세요");
		_in.nextLine();
		_in.nextLine();
	}
}
