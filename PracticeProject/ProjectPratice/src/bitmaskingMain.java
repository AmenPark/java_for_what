// 비트마스킹을 통한 멀티초이스 구현
// 1 - 24시간. 2- 와이파이. 4- 주차장, 8- 흡연실.
public class bitmaskingMain {
	public static void main(String[] args) {
		int option = 13;
		String[] options = {"24시간", "와이파이", "주차장", "흡연실"};
		int checker = 1;
		
		for (String opt:options) {
			if ((checker&option) > 0) {
				System.out.println(opt+" 지원!");
			}
			checker <<=1;
		}
		
		
	}
}
