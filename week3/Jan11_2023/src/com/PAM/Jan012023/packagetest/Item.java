package com.PAM.Jan012023.packagetest;
/*
 * object로부터 모든것이 상속된다. 아무것도 안 써두어도 object를 상속받는다.
 */
public class Item extends Object {
	String name;
	int price;
	
	
	
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}



	public void printinfo() {
		System.out.println(name);
		System.out.println(price);
	}
}
