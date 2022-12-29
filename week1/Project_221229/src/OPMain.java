import java.util.Scanner;

//자전거 앞바퀴 둘레가 얼마인지 입력을 받는다. 단위:cm
//앞 기어 톱니수 입력을 받는다.
//뒷 기어 톱니수 입력을 받는다.
//페달 돌린 횟수 입력을 받는다.
//이동거리 계산하기.
public class OPMain {
	public static void main(String[] args) {
		Scanner _in = new Scanner(System.in);
		System.out.print("바퀴 둘레 길이(cm): ");
		double length = _in.nextDouble();

		System.out.print("페달 기어 톱니 수(개): ");
		int pedalGear = _in.nextInt();

		System.out.print("바퀴 기어 톱니 수(개): ");
		int wheelGear = _in.nextInt();

		System.out.print("페달 돌린 횟수(회): ");
		int pedalingNum = _in.nextInt();

		System.out.println("------------");

		double displacement = (length * pedalingNum) * pedalGear / wheelGear / 100;
		System.out.printf("이동거리 : %.2f m", displacement);
		

	}
}
