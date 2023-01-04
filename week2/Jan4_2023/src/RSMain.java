import java.util.Iterator;

// 디버깅은 이클립스에서 F11으로 실행가능.
// 숫자 왼쪽의 영역에서 더블클릭으로 break point 설정/
// f6으로 한줄실행, f8로 breakpoint에서만 멈추기.
// ctrl+f5로 정지.
// 반복문 내부 변수선언은 하지 않는것이 좋다. 성능에 유의미한 차이가 난다.
// ctrl+alt+위아래 하면 코드 한 줄이 복제된다. 이거하고 alt로 옮기면 ctrl+c v보다 좋나?
public class RSMain {
	public static void main(String[] args) {
//		int a = 1;
//		for (int i = 1; i < 8; i++) {
//			a *= i;
//		}
//		System.out.println(a);
//
//		a = 0;
//		for (int i = 1; i < 10; i++) {
//			if (i % 2 == 1) {
//				a += i;
//			}
//		}
//		System.out.println(a);
//
//		a = 0;
//		for (int i = 1; i < 11;) {
//			if (i % 2 == 0) {
//				a -= i;
//			} else {
//				a += i;
//			}
//
//		}
//		System.out.println(a);

//		int i = 0;
//		for (; i < 10;) {
//			System.out.println(i);
//			i++;
//		}
//		
//		System.out.println("구구단을 외우자");
//		for (int i = 2; i < 10; i++) {		
//			System.out.printf("====%d단====\t", i);
//		}
//		System.out.println("");
//		
//		for (int j = 1; j < 10; j++) {
//			for (int i=2;i<=9;i++) {
//				System.out.printf("%d x %d = %d\t",i,j,i*j );
//			}
//			System.out.println();
//			
//		}
//		int n = 5;
//		for (int j = 0; j < n; j++) {
//			for (int i = 0; i < n*2; i++) {
//				if ( (i<n?n-i:i-n) <= j) {
//					System.out.print("*");
//				} else {
//					System.out.print(" ");
//				}
//			}
//			System.out.println();
//		}

//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < i; j++) {
//				System.out.printf("%s",j%2==1?"a":"b");
//			}
//			System.out.println();
//		}
//		
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 2*i-1; j++) {
//				System.out.printf("%s",i%2==1?"a":"b");
//			}
//			System.out.println();
//		}
//		for (int i = 1; i <= 10; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//		int s = 0;
//		for (int i = 1; i <100; i++) {
//			s+=i;
//			if (s>=1000) {
//				System.out.println(i);
//				break;
//			}
//		}
//		System.out.println(s);
		int i=0;
		for (;true;) {
			System.out.println(i);
			i++;
		}

	}
}

