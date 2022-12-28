package test_221228_print;

public class printMain2 {
	public static void main(String[] args) {
		System.out.printf("기온\t: %d, %s %3.3f %04d\b", 5, "인가요?\n", 345.1317,1);
		System.out.printf("글자데이터 %15.12s\n","아브라카타브라");
		System.out.printf("실험중\t%s\t%s\n","test1","test2");
		System.out.printf("실험중\t%s\t%s\n","test1bb","test2");
		System.out.printf("습도 : %.0f%s", 20.345,'%');
	}
}
