// OOP - 자바로 실생활 묘사. 구현.
// OOD - 객체지향 설계. 시스템 설계/객체 설계로 나뉨.
// OOA - 객체지향 분석. 문제 정의-모형제작.
// ctrl+click하면 해당 함수로(다른파일이어도)이동가능하다.

//DTO - Data Transfer Object. 데이터를 묶어주는 역할을 한다. 중간개체.
// getter, setter만 갖고있다.
// javaBean. 원두라고도 부른다?
//DAO - db에 접근하기 위해 쓰인다.
//VO - valoue object - read only. dto와 유사하지만 setter이 없다.
public class Omain2 {
	public static void main(String[] args) {
		Doctor d = new Doctor("김갑동", 28);
		d.workStart();
		
	}
}
