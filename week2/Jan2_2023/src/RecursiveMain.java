import java.util.Scanner;
// 재귀를 이용한 원하는 숫자가 입력될 때 까지 반복호출
// 에러처리를 배우기 전이라 숫자입력 내에서 분리해서 홀-짝을 분리하였다

public class RecursiveMain {
	
	private static int getOddNumber() {
		Scanner _in = new Scanner(System.in);
		System.out.print("홀수 입력 :");
		int var = _in.nextInt();
		return var%2==1?var:getOddNumber();
		
	}
	
	public static void main(String[] args) {

		int var = getOddNumber();
		
		System.out.println("---------");
		System.out.printf("입력한 홀수 숫자는 %d 입니다.",var );
		
		
	}
}
