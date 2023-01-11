package com.PAM.Jan012023.packagetest;

public class Computer extends Item {
	String cpu;
	int ram;
	int hdd;
	@Override
	
	
	public void printinfo() {
		// TODO Auto-generated method stub
		super.printinfo();
		System.out.println(cpu);
		System.out.println(ram);
		System.out.println(hdd);
	}
	public Computer(String name, int price, String cpu, int ram, int hdd) {
		super(name, price);
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
}
