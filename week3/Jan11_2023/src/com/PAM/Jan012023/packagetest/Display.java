package com.PAM.Jan012023.packagetest;

public class Display extends Item {
	
	String maker;

	public Display(String name, int price, String maker) {
		super(name, price);
		this.maker = maker;
	}


	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println(maker);
		
	}
}
