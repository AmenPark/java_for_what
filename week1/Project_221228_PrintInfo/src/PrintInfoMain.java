// 파일 실행시 jar파일로 export하여 사용.
// bat(cmd 실행파일) 파일 생성해서 사용자친화적으로 사용가능.
// 이 파일을 돌리기 위해서는 JRE java runtime environment가 존재해야함.
public class PrintInfoMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("*********************************");
		System.out.printf("*%5s\t: %15s\t*\n","이름","홍길동");
		System.out.printf("*%5s\t: %15s\t*\n","연락처","010-0985-8282");
		System.out.printf("*%5s\t: %15s\t*\n","거주지","율도국");
		System.out.println("*********************************");
		
		Thread.sleep(5000);
	}
}
