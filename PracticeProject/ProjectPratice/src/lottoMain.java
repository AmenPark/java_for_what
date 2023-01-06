package Practice;

import java.util.Random;

public class lottoMain {
	final static int N = 10_000;
	public static void getLotto(Random _r) {
		int[] lotto = new int[N];
		int var, temp;
		
		for(int i=0;i<N;i++) {
			var = _r.nextInt(N-i)+1;
			for (int j=0;j<i;j++) {
				if (var>=lotto[j]) {
					var++;
				} else {
					temp = lotto[j];
					lotto[j] = var;
					var = temp;
				}
			}
			lotto[i] = var;
		}
	}
	
	public static boolean checkIn(int[] lotto, int j, int var) {
		for (int i=0;i<j;i++) {
			if(var == lotto[i]) {
				return false;
			}
		}
		return true;
	}
	public static void useForFunc(Random _r) {
		int[] lotto = new int[N];
		int var;
		for (int i = 0; i < N;) {
			var = _r.nextInt(N)+1;
			if (checkIn(lotto, i, var)) {
				lotto[i] = var;
				i++;
			}
		}
	}
	
	public static int useRecursive(Random _r, int i, int[] lotto) {
		int var = _r.nextInt(N);
		for(int j=0;j<i;j++) {
			if (var==lotto[j]) {
				return useRecursive(_r,i, lotto);
			}
		}
		return var;
	}
	
	public static void userRecursiveFunc(Random _r) {
		int[] lotto = new int[N];
		for(int i=0;i<N;i++) {
			lotto[i] = useRecursive(_r,i, lotto);
		}
	}
	
	public static void main(String[] args) {
		// 20만 8.28초. 10만에 2.14초.
		// 0.088465, 0.089163
		
		Random _r = new Random();
		long startTime = System.nanoTime();
//		getLotto(_r);
		useForFunc(_r);
//		userRecursiveFunc(_r);
		long endTime = System.nanoTime();
		System.out.printf("%.6f초 걸렸습니다.\n", (endTime-startTime)/1_000_000_000.0);
	}
}
