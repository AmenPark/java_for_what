package com.PAM.Jan312023;


/*
 * AOP - Aspect Oriented Programming.
 * OOP의 발전.
 * 기본 OOP는 객체지향으로 객체의 기준에서 표현을 했다.
 * 그 객체의 행동들을 보면, 어떤 공통된 행동이 중복되기도 한다.
 * 그러한것들을 모아서 따로 코드를 빼는것을 의미한다.
 * 그러니까 결국 행동 쪼개기이다.
 * 
 * 언제 횡단관심을 삽입하는가? 실행전후, 예외, 반환후 등등.
 * 어떤 클래스에 삽입하는가?
 * 무엇을 삽입하는가?
 * 핵심관심-객체의 주 행동-에서 직접 실행이 아니라 대리인을 통해 간접실행.
 * 
 * 
 * MVC - Model, View, Controller
 * Model은 사용자에게 은닉되어있다. back. View는 front. C는 poject leader급이 한다.
 * 
 * 여러개의 값을 리턴하려면 list, set, map, array 등이 있다.
 * 그러나 이 방법보다 일반적으로는 반환을 위한 class를 만들어서 사용한다.
 * DTO - Data Temp/ Transfer Object 라고도 부르고
 * VO - Value Object,
 * Plain Old Java Object? 라고도 불린다.
 * javabean 등의 계열이다.
 * 당연하지만 M, 모델에 포함된다.
 * 
 */
public class Jan31_2023_AOP {
	
	public static void main(String[] args) {
		V v = new V();
		
		int a = V.getNum();
		int b = V.getNum();
		int[] c = M.calcul(a,b);
		V.print(c[0]);
		V.print(c[1]);
		V.print(c[2]);
		V.print(c[3]);
		
		v.destroy();
	}
	
}
