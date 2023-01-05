
public class arrayMain {
	public static void main(String[] args) throws InterruptedException {
		
		int[] arr = new int[4]; //기본 문법.
		int[] arr2 = {10,20,30,40,50}; // 초기화시의 문법. 
		// 이 배열은 시작시 크기가 정해져서 잘 쓰기가 어렵다.
		
		System.out.println(arr2.length);	// 배열의 길이
		System.out.println(arr2); 			// 주소출력	
		System.out.println(arr2[0]);		// 배열의 원소 0번
		
		arr[0] = 1;
		for(int x:arr2) {
			System.out.println(x);
		}
//		 for문을 호출시 이클립스는 가장 가까운 배열을 조합하도록 자동으로 완성해줌.
//		for (int i = 0; i < arr2.length; i++) {
//		}
		
		System.out.println(args.length);
		for (String i : args) {
			System.out.println(i);
		}
//		main에서의 args는 cmd에서 java -jar projectname.jar abc de f 같은 방식으로 하면 abc, de, f가 들어감.
//		그러니까 기본적으론 빈 배열이 됨.
		

		
	}

}
