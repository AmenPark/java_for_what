import java.util.Random;

public class sortMain {
	static int[] arr = new int[100_000];
	public static void checkarr() {
		int before_var = arr[0];
		for (int k:arr) {
			if (k<before_var) {
				System.out.println("잘못된 정렬을 찾았다!");
				break;
			}
			before_var = k;
		}
		System.out.println("정렬 완료. 검사끝.");
	}
	public static void makearr() {
		Random _r = new Random();
		for (int i=0;i<arr.length;i++) {
			arr[i] = _r.nextInt();
		}
	}
	public static void Mergesort(int[] arr ) {
		Mergesort(arr, 0, arr.length);
	}
	public static void sortMerge(int[] arr, int i, int N, int j) {
		int[] temp = new int[N-i];
		for(int k=i;k<N;k++) {
			temp[k-i] = arr[k];
		}
		int ind0 = i;
		int ind1 = 0;
		int ind2 = N;
		while (true) {
			if(temp[ind1] > arr[ind2]) {
				arr[ind0] = arr[ind2];
				ind2++;
			} else {
				arr[ind0] = temp[ind1];
				ind1++;
			}
			ind0++;
			if (ind2 == j) {
				while (ind1<temp.length) {
					arr[ind0] = temp[ind1];
					ind0++;
					ind1++;
				}
				break;
			} else if (ind1 == temp.length) {
				break;
			}
		}
	}
	public static void Mergesort(int[] arr, int i, int j ) {
		if (j-i == 2) {
			j--;
			if (arr[i] > arr[j]) {
				arr[i] += arr[j];
				arr[j] = arr[i] - arr[j];
				arr[i] -= arr[j];
			}
		}
		else if (j-i>2) {
			int midvar = (j+i)/2;
			Mergesort(arr, i, midvar);
			Mergesort(arr,midvar,j);
			
			sortMerge(arr, i, midvar, j);
			
		}
	}

	public static void bubbleSort() {
		int temp;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i; j++) {
				if (arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void selectionSort() {
		int temp;
		int id = 0;
		int target = 0;
		int var=arr[0];
		while(id<arr.length-1) {
			for (int j=id;j<arr.length;j++) {
				if (var>arr[j]) {
					target = j;
					var = arr[j];
				}
			}
			temp = arr[id];
			arr[id] = var;
			arr[target] = temp;
			id++;
			target = id;
			var = arr[id];
		}
	}
	public static void main(String[] args) {
		makearr();
		System.out.println("검사 시작!");
		long startTime = System.nanoTime();
//		Mergesort(arr);
		bubbleSort();
//		selectionSort();
		long endTime = System.nanoTime();
		long var = endTime - startTime;
		System.out.printf("%.2f초 걸렸습니다.\n",var / 1_000_000_000.0);
		checkarr();
	}
}
