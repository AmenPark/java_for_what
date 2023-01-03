
public class RSMain {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i+=2) {
			System.out.print(i+" ");
		}
		System.out.println("");
		for (int i = -3; i < 4; i++) {
			System.out.print(i+" ");
		}
		System.out.println("");
		
		for (int i = 5; i >=0; i--) {
			System.out.print(i+" ");
		}
		System.out.println("");
		
		for (int i = 1; i <= 10 ; i++) {
			if (i%2==1) {
				System.out.print(i+" ");
			} else {
				System.out.print("짝 ");
			}
		}
		System.out.println("");
//		int i=0;
//		do {
//			System.out.println(i);
//			i++;
//		} while (i<=10);
//		
//		while (i>0) {
//			System.out.println("wwww"+i);
//			i++;
//		}
		
		
	}
}
