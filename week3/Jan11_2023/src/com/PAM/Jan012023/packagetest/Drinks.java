package com.PAM.Jan012023.packagetest;

public class Drinks extends Menu{
	int alcholic;
	
	public Drinks(String name, int price, int alcholic) {
		super(name, price);
		this.alcholic = alcholic;
	}

	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println(alcholic);
	}
}
