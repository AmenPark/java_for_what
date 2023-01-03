import java.util.Scanner;

//카페가 있다. 카페 검색을 했을때 옵션을 보여주고 싶다.
//24시간여부, 와이파이존재여부, 주차장 여부, 흡연실 여부 옵션이 존재.
//
public class projectMultiChoiceMain {
	public static void main(String[] args) {
		Scanner _in = new Scanner(System.in);
		int opt = _in.nextInt();
		opt%=16;
		
		
		if ((opt&1) > 0) {
			System.out.println("24시간 영업 중!");
		}
		if ((opt&2) > 0) {
			System.out.println("와이파이존입니다!");
		}
		if ((opt&4) > 0) {
			System.out.println("주차장 이용 가능!");
		}
		if ((opt&8) > 0) {
			System.out.println("흡연실도 있어요!");
		}
		
	}
}
