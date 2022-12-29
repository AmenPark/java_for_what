import java.util.Scanner;

// 마트에서 장을 봤다. 구매한 물건 가격, 낸 돈을 통해서 거스름돈 종류별로 구하시오?

public class OperatorMain {
	public static void main(String[] args) {
		Scanner _in = new Scanner(System.in);
		System.out.print("구매한 물건 가격:");
		int price = _in.nextInt();
		System.out.println("지불한 금액:");
		int pay = _in.nextInt();
		System.out.println("-----------");
		int change = pay - price;
		
		System.out.printf("거스름돈 : %d원\n", change);
		System.out.printf("50000원 : %d개\n", change / 50000);
		change %= 50000;
		System.out.printf("10000원 : %d개\n", change / 10000);
		change %= 10000;
		System.out.printf("5000원 : %d개\n", change / 5000);
		change %= 5000;
		System.out.printf("1000원 : %d개\n", change / 1000);
		change %= 1000;
		System.out.printf("500원 : %d개\n", change / 500);
		change %= 500;
		System.out.printf("100원 : %d개\n", change / 100);
		change %= 100;
		System.out.printf("50원 : %d개\n", change / 50);
		change %= 50;
		System.out.printf("10원 : %d개\n", change / 10);
		
	}
}
