/*
 * 생성자 Constructor.
 * return이 없음. 그냥 Public {클래스명}으로 정의.
 * 여기서는 Items가 생성자.
 */
public class Items {
	String Name;
	int price;
	static final String MADEFROM = "한국";
	/*
	 * 이클립스에서는 우클릭-source-generate constructor using field를 이용해서도 오버로딩 가능하다.
	 */
	public Items(String n, int m){
		Name = n;
		price = m;
	}
	public Items(String n) {
		Name = n;
		price = 100000;
	}
	public Items(int m) {
		price = m;
		Name = "무작위선물세트";
	}
	
	public Items() {
		price = 100000;
		Name = "무작위선물세트";
	}
		
	public void printInfo() {
		System.out.println(Name);
		System.out.println(price);
		System.out.println(MADEFROM);
	}
}
