package com.PAM.jan1223.cars;

public class Bus extends Car{
	private int money;

	Bus(String name, int idnum, int money) {
		super(name, idnum);
		this.money = money;
	}
	
	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println(money);
	}
}
