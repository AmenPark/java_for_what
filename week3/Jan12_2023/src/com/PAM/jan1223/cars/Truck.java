package com.PAM.jan1223.cars;

public class Truck extends Car {
	private int fork;

	Truck(String name, int idnum, int fork) {
		super(name, idnum);
		this.fork = fork;
	}
	
	@Override
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println(fork);
	}
	
	
	
}
