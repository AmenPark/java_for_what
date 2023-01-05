import java.util.Scanner;

// 거스름돈 계산해주는 프로그램.
public class coinMain {
	public static int getInt(Scanner _in) {
		int rt = _in.nextInt();
		return rt<0?getInt(_in):rt;
	}
	public static int getChange(int pay, int price) {
		return pay - price;
	}
	
	public static void main(String[] args) {
		Scanner _in = new Scanner(System.in);
		int[] currency = {50000,10000,5000,1000,500,100,50,10};
		int pay, price, change;
		while(true) {
			System.out.print("지불한 돈은?:");
			pay = getInt(_in);
			System.out.print("산 물건의 가격은?");
			price = getInt(_in);
			change = getChange(pay,price);
			if(change>0) {
				break;
			}
			System.out.println("물건을 못 사요");
		}
		System.out.printf("받을 거스름돈 총 합은 %d원.\n", change);
//		for(int c:currency) {
//			if (c<=change) {
//				System.out.printf("%d원짜리는 %d개가 필요합니다.\n",c, change/c);
//				change %= c;
//			}
//		}
		
		int c = 50000;
		boolean b = true;
		while (c>9) {
			System.out.printf("%d원짜리는 %d개 필요합니다.\n",c,change/c);
			change%=c;
			if(b) {
				c/=5;
				b = !b;
			}else {
				c/=2;
				b = !b;
			}
			
		}
		
		
		
	}
}
