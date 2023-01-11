package com.PAM.Jan012023.packagetest;

public class Meat extends Menu {
	String cooked;
	
	public Meat(String name, int price, String cooked) {
		super(name, price);
		this.cooked = cooked;
	}

	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println(cooked);
	}
}
